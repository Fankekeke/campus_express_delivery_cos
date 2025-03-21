<template>
  <div style="background:#ECECEC; padding:30px;width: 100%">
    <a-row :gutter="20">
      <div style="text-align: center" v-if="orderList.length === 0">
        <a-icon type="folder-open" theme="twoTone" style="font-size: 80px"/>
        <p style="font-size: 25px">暂无订单</p>
      </div>
      <a-col :span="6" v-for="(item, index) in orderList" :key="index" style="margin-bottom: 30px">
        <a-card hoverable style="width: 100%">
          <template slot="actions" class="ant-card-actions">
            <a-icon key="ellipsis" type="ellipsis" @click="orderMapOpen(item)"/>
          </template>
          <a-card-meta :title="item.orderName">
            <div slot="description">
              <div>
                <a-icon type="user" />
                {{item.userName}}
                &nbsp;|&nbsp;
                <a-icon type="phone" />
                {{item.phone}}
              </div>
              <div style="margin-top: 10px">
                <a-icon type="compass" />
                {{item.kilometre}}公里
                &nbsp;|&nbsp;
                 <a-icon type="clock-circle-o" />
                {{moment(item.createDate).format('YYYY-MM-DD HH:mm:ss')}}
              </div>
              <div style="margin-top: 10px">
                收益：
                <span style="color: red">{{(item.afterOrderPrice).toFixed(2)}}元</span>
              </div>
            </div>
            <a-avatar
              slot="avatar"
              shape="square"
              :src="'http://127.0.0.1:9527/imagesWeb/' + item.userImages"
            />
          </a-card-meta>
        </a-card>
      </a-col>
    </a-row>
    <MapView
      @close="handleorderMapViewClose"
      :orderShow="orderMapView.visiable"
      :orderData="orderMapView.data">
    </MapView>
  </div>
</template>

<script>
import {mapState} from 'vuex'
import moment from 'moment'
import MapView from '../map/Map.vue'
moment.locale('zh-cn')
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
  name: 'User',
  components: {MapView},
  computed: {
    ...mapState({
      currentUser: state => state.account.user
    })
  },
  data () {
    return {
      form: this.$form.createForm(this),
      formItemLayout,
      loading: false,
      courseInfo: [],
      dataLoading: false,
      fileList: [],
      previewVisible: false,
      previewImage: '',
      expertInfo: null,
      price: 0,
      orderList: [],
      orderMapView: {
        visiable: false,
        data: null
      }
    }
  },
  mounted () {
    this.getExpertInfo()
  },
  methods: {
    moment,
    orderMapOpen (row) {
      this.orderMapView.data = row
      this.orderMapView.visiable = true
    },
    checkOrder (orderId) {
      this.$get(`/cos/order-info/checkOrder`, {orderId, userId: this.currentUser.userId}).then((r) => {
        this.$message.success('接单成功！请在订单中心查看')
        this.getExpertInfo(this.currentUser.userId)
      })
    },
    isDuringDate (beginDateStr, endDateStr, curDataStr) {
      let curDate = new Date(curDataStr)
      let beginDate = new Date(beginDateStr)
      let endDate = new Date(endDateStr)
      if (curDate >= beginDate && curDate <= endDate) {
        return true
      }
      return false
    },
    handleorderMapViewClose () {
      this.orderMapView.visiable = false
    },
    getListData (value) {
      let listData = []
      this.courseInfo.forEach(item => {
        if ((moment(value).format('YYYY-MM-DD')) === (moment(item.createDate).format('YYYY-MM-DD'))) {
          listData.push({type: 'success', content: item.code})
        }
      })
      return listData || []
    },
    getExpertInfo () {
      this.$get(`/cos/order-info/notCheckList`).then((r) => {
        this.orderList = r.data.data
        console.log(this.orderList)
      })
    },
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
    setFormValues ({...expert}) {
      this.rowId = expert.id
      let fields = ['code', 'name', 'createDate', 'sex']
      let obj = {}
      Object.keys(expert).forEach((key) => {
        if (key === 'images') {
          this.fileList = []
          this.imagesInit(expert['images'])
        }
        if (key === 'sex') {
          expert[key] = expert[key].toString()
        }
        if (fields.indexOf(key) !== -1) {
          this.form.getFieldDecorator(key)
          obj[key] = expert[key]
        }
      })
      this.form.setFieldsValue(obj)
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
          this.$put('/cos/staff-info', {
            ...values
          }).then((r) => {
            this.$message.success('更新成功')
            this.loading = false
            this.getExpertInfo(this.currentUser.userId)
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
  >>> .ant-card-meta-title {
    font-size: 13px;
    font-family: SimHei;
  }
  >>> .ant-card-meta-description {
    font-size: 12px;
    font-family: SimHei;
  }
</style>
