<template>
  <a-modal v-model="show" title="修改兑换" @cancel="onClose" :width="800">
    <template slot="footer">
      <a-button key="back" @click="onClose">
        取消
      </a-button>
      <a-button key="submit" type="primary" :loading="loading" @click="handleSubmit">
        修改
      </a-button>
    </template>
    <a-form :form="form" layout="vertical">
      <a-row :gutter="20">
        <a-col :span="12">
          <a-form-item label='兑换名称' v-bind="formItemLayout">
            <a-input v-decorator="[
            'name',
            { rules: [{ required: true, message: '请输入兑换名称!' }] }
            ]"/>
          </a-form-item>
        </a-col>
        <a-col :span="12">
          <a-form-item label='所需积分' v-bind="formItemLayout">
            <a-input-number style="width: 100%" v-decorator="[
            'integral',
            { rules: [{ required: true, message: '请输入所需积分!' }] }
            ]" :min="1" :step="1"/>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label='兑换描述' v-bind="formItemLayout">
            <a-textarea :rows="6" v-decorator="[
            'content',
             { rules: [{ required: true, message: '请输入兑换描述!' }] }
            ]"/>
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
  name: 'materialEdit',
  props: {
    materialEditVisiable: {
      default: false
    }
  },
  computed: {
    ...mapState({
      currentUser: state => state.account.user
    }),
    show: {
      get: function () {
        return this.materialEditVisiable
      },
      set: function () {
      }
    }
  },
  data () {
    return {
      rowId: null,
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
    imagesInit (images) {
      if (images !== null && images !== '') {
        let imageList = []
        images.split(',').forEach((image, index) => {
          imageList.push({uid: index, name: image, status: 'done', url: 'http://127.0.0.1:9527/imagesWeb/' + image})
        })
        this.fileList = imageList
      }
    },
    setFormValues ({...material}) {
      this.rowId = material.id
      let fields = ['name', 'content', 'integral']
      let obj = {}
      Object.keys(material).forEach((key) => {
        if (key === 'images') {
          this.fileList = []
          this.imagesInit(material['images'])
        }
        if (key === 'status') {
          material[key] = material[key].toString()
        }
        if (fields.indexOf(key) !== -1) {
          this.form.getFieldDecorator(key)
          obj[key] = material[key]
        }
      })
      this.form.setFieldsValue(obj)
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
      // 获取图片List
      let images = []
      this.fileList.forEach(image => {
        if (image.response !== undefined) {
          images.push(image.response)
        } else {
          images.push(image.name)
        }
      })
      this.form.validateFields((err, values) => {
        values.id = this.rowId
        values.images = images.length > 0 ? images.join(',') : null
        if (!err) {
          this.loading = true
          this.$put('/cos/material-info', {
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
