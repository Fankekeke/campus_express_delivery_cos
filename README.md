### 基于SpringBoot + Vue的校园快递配送系统.

校园跑腿 快递配送 配送系统 校园配送 快递小程序 配送员接单 校园物流 校内快递

###### 管理员：
公告信息 、用户地址 、优惠券管理 、配送订单评价 、兑换记录 、物品管理 、配送订单管理 、配送员管理 、配送员收益 、用户管理 、提现记录 、配送员审核 、接单中心 、投诉记录 、消息通知 、社区论坛 、贴子回复 、配送价格规则 、配送排行、数据统计。

###### 用户/配送员：
小程序账户注册登录、个人信息修改、优惠券兑换、地址管理、我的订单、我的收益、消息通知、社区论坛、发帖回复、积分兑换、我的优惠券、下单配送计算、在线沟通、申请配送员、在线接单、订单评价、订单投诉。

#### 安装环境

JAVA 环境 

Node.js环境 [https://nodejs.org/en/] 选择14.17

Yarn 打开cmd， 输入npm install -g yarn !!!必须安装完毕nodejs

Mysql 数据库 [https://blog.csdn.net/qq_40303031/article/details/88935262] 一定要把账户和密码记住

redis

Idea 编译器 [https://blog.csdn.net/weixin_44505194/article/details/104452880]

WebStorm OR VScode 编译器 [https://www.jianshu.com/p/d63b5bae9dff]

#### 采用技术及功能

后端：SpringBoot、MybatisPlus、MySQL、Redis、
前端：Vue、Apex、Antd、Axios

平台前端：vue(框架) + vuex(全局缓存) + rue-router(路由) + axios(请求插件) + apex(图表)  + antd-ui(ui组件)

平台后台：springboot(框架) + redis(缓存中间件) + shiro(权限中间件) + mybatisplus(orm) + restful风格接口 + mysql(数据库)

开发环境：windows10 or windows7 ， vscode or webstorm ， idea + lambok


#### 前台启动方式
安装所需文件 yarn install 
运行 yarn run dev

#### 默认后台账户密码
[管理员]
admin
1234qwer

#### 项目截图
暂无

|  |  |
|---------------------|---------------------|
| ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/f5e91d86-310f-4111-bfe8-04e0b7b055e0.png) | ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/454515fb-2463-47f7-a500-35401bc079aa.png) |
| ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/e447a13a-d1c5-4e69-b061-d894fef7c8e5.png) | ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/25947bbd-f2d5-46ac-ad0a-9f6e218d6910.png) |
| ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/d10e855d-bfbd-4657-9e29-c135b1973cbb.png) | ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/8b62f175-7fe0-4190-85aa-5c5f528810e4.png) |
| ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/c4213d24-8a49-40c6-af83-abc39186a3d1.png) | ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/7e62d7e2-3298-4608-8d6e-1fcbb7b8473e.png) |
| ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/c0fe139b-28fe-433b-9274-ff5532e0041b.png) | ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/7db593fd-18f1-4950-b9b6-6997b43e7b9a.png) |
| ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/b5075868-b8eb-4d88-bb6f-ca2a7703d73b.png) | ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/004fb194-6703-42e8-9d42-c1e479893a5a.png) |
| ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/a6e11f18-119d-46a5-9356-a767d1476c83.png) | ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/2bdc98f9-a462-4ca1-91cc-9bddd84da105.png) |
| ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/a2b607b4-f347-45cf-86b0-cb20f9db5658.png) | ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/ff41a5a7-51a5-4c96-9c60-0e20b2dbcb63.png) |
| ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/92090130-219a-4171-bd09-4f046f959167.png) |  |

|  |  |
|---------------------|---------------------|
| ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/51331379-1bf9-46e6-8e9a-03d69bef0f49.png) | ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/3dc6f4e7-7b51-420d-8e82-17a79baf72c0.png) |
| ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/34998475-cbe9-413b-a6bf-cce8c7313c8a.png) | ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/1e97f1ef-5bcf-4080-9bbf-bb08063b79c1.png) |
| ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/5249bf69-2c8f-468f-8420-09b86fce685f.png) | ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/0f86ec82-d089-469c-bc41-dc81a2137a44.png) |
| ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/914f6307-1eae-468a-8a65-5c8421406b01.png) | ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/0f2def3a-01e6-490d-87bb-b3474250f959.png) |
| ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/84e64eca-2245-4b62-9f5e-e2e8f36dfb8e.png) | ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/f3a15e94-e28e-481e-9e08-3ac833933f6d.png) |
| ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/54d4c328-fa21-45af-869d-2c34093326ba.png) | ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/e9172a0e-9ad0-44cb-a4a2-22d1fce1169d.png) |
| ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/8fbc3748-b300-4ded-813b-b2c657bf165f.png) | ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/ce0c1cf3-4d25-4675-9fd8-b50892444427.png) |
| ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/8b29271b-2b77-47c5-9b07-d28b375d7186.png) | ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/a663a92d-e431-471b-b054-15c5300431ec.png) |

![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/work/936e9baf53eb9a217af4f89c616dc19.png)

#### 演示视频

暂无

#### 获取方式

Email: fan1ke2ke@gmail.com

WeChat: `Storm_Berserker`

`附带部署与讲解服务，因为要恰饭资源非免费，伸手党勿扰，谢谢理解😭`

> 1.项目纯原创，不做二手贩子 2.一次购买终身有效 3.项目讲解持续到答辩结束 4.非常负责的答辩指导 5.**黑奴价格**

> 项目部署调试不好包退！功能逻辑没讲明白包退！

#### 其它资源

[2025年-答辩顺利通过-客户评价🍜](https://berserker287.github.io/2025/06/18/2025%E5%B9%B4%E7%AD%94%E8%BE%A9%E9%A1%BA%E5%88%A9%E9%80%9A%E8%BF%87/)

[2024年-答辩顺利通过-客户评价👻](https://berserker287.github.io/2024/06/06/2024%E5%B9%B4%E7%AD%94%E8%BE%A9%E9%A1%BA%E5%88%A9%E9%80%9A%E8%BF%87/)

[2023年-答辩顺利通过-客户评价🐢](https://berserker287.github.io/2023/06/14/2023%E5%B9%B4%E7%AD%94%E8%BE%A9%E9%A1%BA%E5%88%A9%E9%80%9A%E8%BF%87/)

[2022年-答辩通过率100%-客户评价🐣](https://berserker287.github.io/2022/05/25/%E9%A1%B9%E7%9B%AE%E4%BA%A4%E6%98%93%E8%AE%B0%E5%BD%95/)

[毕业答辩导师提问的高频问题](https://berserker287.github.io/2023/06/13/%E6%AF%95%E4%B8%9A%E7%AD%94%E8%BE%A9%E5%AF%BC%E5%B8%88%E6%8F%90%E9%97%AE%E7%9A%84%E9%AB%98%E9%A2%91%E9%97%AE%E9%A2%98/)

[50个高频答辩问题-技术篇](https://berserker287.github.io/2023/06/13/50%E4%B8%AA%E9%AB%98%E9%A2%91%E7%AD%94%E8%BE%A9%E9%97%AE%E9%A2%98-%E6%8A%80%E6%9C%AF%E7%AF%87/)

[计算机毕设答辩时都会问到哪些问题？](https://www.zhihu.com/question/31020988)

[计算机专业毕业答辩小tips](https://zhuanlan.zhihu.com/p/145911029)

#### 接JAVAWEB毕设，纯原创，价格公道，诚信第一

`网站建设、小程序、H5、APP、各种系统 选题+开题报告+任务书+程序定制+安装调试+项目讲解+论文+答辩PPT`

More info: [悲伤的橘子树](https://berserker287.github.io/)

<p><img align="center" src="https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/%E5%90%88%E4%BD%9C%E7%89%A9%E6%96%99%E6%A0%B7%E5%BC%8F%20(3).png" alt="fankekeke" /></p>

