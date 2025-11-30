const app = getApp();
let http = require('../../../utils/request')
Page({
    data: {
        StatusBar: app.globalData.StatusBar,
        CustomBar: app.globalData.CustomBar,
        TabbarBot: app.globalData.tabbar_bottom,
        orderInfo: null,
        merchant: null,
        user: null,
        staff: [],
        commoditId: null,
        startAddress: null,
        endAddress: null,
        vehicle: null,
        markers: [{
            id: 0,
            latitude: 39.980014,
            longitude: 116.313972,
            iconPath: 'http://127.0.0.1:9527/imagesWeb/外卖员.png', // 配送员图标路径
            width: 30,
            height: 30,
            callout: {
                content: '配送员位置',
                display: 'ALWAYS'
            }
        }]
    },
    onLoad: function (options) {
        this.getOrderDetail(options.orderId)
    },
    message(event) {
        wx.getStorage({
            key: 'userInfo',
            success: (res) => {
                wx.navigateTo({
                    url: '/pages/user/detail/index?takeUser=' + event.currentTarget.dataset.shopid + '&sendUser=' + res.data.id + '&otherName=' + event.currentTarget.dataset.shopname + ''
                });
            },
            fail: res => {
                wx.showToast({
                    title: '请先进行登录',
                    icon: 'none',
                    duration: 2000
                })
            }
        })
    },
    takePhone() {
        wx.makePhoneCall({
            phoneNumber: this.data.user.phone
        })
    },
    getOrderDetail(orderId) {
        http.get('queryOrderDetail', {
            orderId: orderId
        }).then((r) => {
            let order = r.order
            if (order.images) {
                order.imageList = order.images.split(',')
            }
            this.setData({
                orderInfo: order,
                startAddress: r.startAddress,
                endAddress: r.endAddress,
                user: r.user
            })
            if (r.realTimeLocation != null) {
                this.setData({
                    markers: [{
                        id: 0,
                        latitude: r.realTimeLocation.latitude,
                        longitude: r.realTimeLocation.longitude,
                        iconPath: 'http://127.0.0.1:9527/imagesWeb/外卖员.png', // 配送员图标路径
                        width: 30,
                        height: 30,
                        callout: {
                            content: '配送员位置',
                            display: 'ALWAYS'
                        }
                    }]
                })
                console.log(this.data.markers)
            }
        })
    }
});
