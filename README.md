现在的项目中使用了Mvp 的结构，并且采用 Retrofit2+ RxJava2 框架，相信这也是现在主流的配置了吧

BaseProject 是自己对项目中使用 Mvp Retrofit RxJava 等技术做的基础的封装

----

### 项目中包含内容：

1、MVP 模式下的 BaseActivity BaseMvpActivity  BaseFagment BaseMvpFragment 的封装

2、通用的BasePresenter的封装

3、Retrofit 网络请求公共参数的封装及自定义的FastJsonConverter

4、Retrofit 的返回结果和异常的预处理以及Cookie 的保持 

5、Retrofit 的文件上传及文件下载

6、应用内多状态布局封装

### 目前使用的框架：

```
compile 'com.squareup.retrofit2:retrofit:2.3.0'
compile 'com.squareup.retrofit2:adapter-rxjava2:2.3.0'
compile "io.reactivex.rxjava2:rxjava:2.1.0"
compile 'io.reactivex.rxjava2:rxandroid:2.0.1'
compile 'com.squareup.okhttp3:okhttp:3.8.0'
compile 'com.alibaba:fastjson:1.2.24'

compile 'com.jakewharton:butterknife:8.6.0'
annotationProcessor  'com.jakewharton:butterknife-compiler:8.6.0'
```

