<template>
  <a-modal v-model="show" title="新增价格规则" @cancel="onClose" :width="450">
    <template slot="footer">
      <a-button key="back" @click="onClose">
        取消
      </a-button>
      <a-button key="submit" type="primary" :loading="loading" @click="handleSubmit">
        提交
      </a-button>
    </template>
    <a-form :form="form" layout="vertical">
      <a-row :gutter="20">
        <a-col :span="24">
          <a-form-item label='规则内容' v-bind="formItemLayout">
            <a-input v-decorator="[
            'remark',
            { rules: [{ required: true, message: '请输入规则内容!' }] }
            ]"/>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label='单价' v-bind="formItemLayout">
            <a-input-number style="width: 100%;" v-decorator="[
            'unitPrice',
            { rules: [{ required: true, message: '请输入单价!' }] }
            ]" :min="1" :step="1"/>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label='类型' v-bind="formItemLayout">
            <a-select v-decorator="[
              'type',
              { rules: [{ required: true, message: '请输入类型!' }] }
              ]">
              <a-select-option value="1">重量</a-select-option>
              <a-select-option value="2">距离</a-select-option>
            </a-select>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label='最小值' v-bind="formItemLayout">
            <a-input-number style="width: 100%" v-decorator="[
                              'minValue',
                              { rules: [{ required: true, message: '请输入最小值!' }] }
                              ]" :min="0" :step="0.1"/>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label='最大值' v-bind="formItemLayout">
            <a-input-number style="width: 100%" v-decorator="[
                              'maxValue',
                              { rules: [{ required: true, message: '请输入最小值!' }] }
                              ]" :min="0" :step="0.1"/>
          </a-form-item>
        </a-col>
      </a-row>
    </a-form>
  </a-modal>
</template>

<script>
import {mapState} from 'vuex'
function getBase64 (file) {
  return new Promise((resolve, reject) => {
    const reader = new FileReader()
    reader.readAsDataURL(file)
    reader.onload = () => resolve(reader.result)
    reader.onerror = error => reject(error)
  })
}
const formItemLayout = {
  labelCol: { span: 24 },
  wrapperCol: { span: 24 }
}
export default {
  name: 'rulesAdd',
  props: {
    rulesAddVisiable: {
      default: false
    }
  },
  computed: {
    ...mapState({
      currentUser: state => state.account.user
    }),
    show: {
      get: function () {
        return this.rulesAddVisiable
      },
      set: function () {
      }
    }
  },
  data () {
    return {
      formItemLayout,
      form: this.$form.createForm(this),
      loading: false,
      fileList: [],
      previewVisible: false,
      previewImage: ''
    }
  },
  methods: {
    handleCancel () {
      this.previewVisible = false
    },
    async handlePreview (file) {
      if (!file.url && !file.preview) {
        file.preview = await getBase64(file.originFileObj)
      }
      this.previewImage = file.url || file.preview
      this.previewVisible = true
    },
    picHandleChange ({ fileList }) {
      this.fileList = fileList
    },
    reset () {
      this.loading = false
      this.form.resetFields()
    },
    onClose () {
      this.reset()
      this.$emit('close')
    },
    handleSubmit () {
      this.form.validateFields((err, values) => {
        if (!err) {
          this.loading = true
          this.$post('/cos/price-rules', {
            ...values
          }).then((r) => {
            this.reset()
            this.$emit('success')
          }).catch(() => {
            this.loading = false
          })
        }
      })
    }
  }
}
</script>

<style scoped>

</style>
