# 文件上传下载经典案例

**本案例只提供了上传下载预览接口，没有前端页面，接口测试使用的是自定义的无侵入Swagger组件，达到目的即可，结合前端的开发本文也将会讲到。**

**开发环境：JDK8，SpringBoot2.x，MySQL5.5，web-uploader**

**组件：swagger(自定义无侵入swagger：详情见另一个开源项目：https://gitee.com/Analyzer/swagger2_package)**

**开发工具：IntelliJ IDEA**

### 项目运行

先看一下效果：**可一次性上传多个文件（这里只演示了一个，因为给忘记了，嫌麻烦就没有重新测试）**

![输入图片说明](https://images.gitee.com/uploads/images/2020/0903/184500_d41dadc1_1676717.png "image-20200903183735347.png")

导入doc目录下的sql文件到数据库，修改application.yml配置文件中的数据库配置、文件保存目录、端口号等等，启动项目即可。

![输入图片说明](https://images.gitee.com/uploads/images/2020/0806/174727_33eb9667_1676717.png "image-20200730183440801.png")

### 接口测试

访问：http://IP:端口/swagger-ui.html

![输入图片说明](https://images.gitee.com/uploads/images/2020/0806/174951_dfb99ceb_1676717.png "image-20200730183631105.png")

**上传文件**
![输入图片说明](https://images.gitee.com/uploads/images/2020/0806/174915_3343d757_1676717.png "image-20200730183749839.png")


后边的接口就不再一一介绍，在代码中有解释。

与前端的对接只需要传过来的是form表单里的<input type="file" name="file">即可。例如：

![输入图片说明](https://images.gitee.com/uploads/images/2020/0806/175323_adb2427c_1676717.png "1.png")

同理其他前端UI框架的文件上传也是利用表单进行传输的。

### 断点续传测试

修改存储文件夹：

![输入图片说明](https://images.gitee.com/uploads/images/2020/0902/102630_3ae46985_1676717.png "image-20200902100514998.png")

修改前端URL常量：

![输入图片说明](https://images.gitee.com/uploads/images/2020/0903/184527_101a101b_1676717.png "image-20200903183521963.png")

打开doc文件夹下的index.html，选择文件，这里为了显示断点续传的效果，我选择了一个大文件，将自动上传

上传中：

![输入图片说明](https://images.gitee.com/uploads/images/2020/0903/184543_34bb6839_1676717.png "image-20200903183705481.png")

上传完成：

![输入图片说明](https://images.gitee.com/uploads/images/2020/0903/184603_40477348_1676717.png "image-20200903183820976.png")



上传完成后再次选择这个文件就会启动秒传功能。

**注：**上传完成后文件配置路径中会生成.conf文件，这个文件就是判断文件是否已经上传的配置，如果删除，则下次上传不会启动秒传，而是创建一个后缀为_tmp的文件，导致新上传文件不可用。所以这里可以进行二次开发进行限制上传、覆盖上传或者文件重命名操作。