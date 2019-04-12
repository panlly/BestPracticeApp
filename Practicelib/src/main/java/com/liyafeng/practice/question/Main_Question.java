package com.liyafeng.practice.question;

public class Main_Question {

    /**
     * @param args
     */
    public static void main(String[] args) {

    }


    /**
     * java.lang.ExceptionInInitializerError
     * 这个异常是在静态代码块初始化的时候（包括静态变量）
     * 抛出了异常导致的，这个异常用可能是空指针或者其他异常
     */
    public static void a1() {
    }

    /**
     * Okhttp 的addInterceptor 和 addNetworkInterceptor 的区别？
     * https://github.com/AndroidPreView/AndroidNote/wiki/Okhttp-的addInterceptor-和-addNetworkInterceptor-的区别？
     * 响应有可能是缓存，应用拦截器会拦截，网络拦截器不会
     */
    public static void a2() {
    }


    /**
     * LinearLayout android:layout_gravity=right 无效问题
     * 当LinearLayout设置 android:orientation="vertical" 的时候，
     * <p>
     * 竖直即vertical方向上，android:layout_gravity="bottom" 是无效的，只有左右left和right有效果。
     * <p>
     * 同理，当设置 android:orientation="horizontal" ，水平方向的设置都是无效的，只有top和bottom设置有效果
     */
    public void a3() {

    }


    /**
     * android TextView setEms 方法名字
     * android TextView setEms() 作用是设置textview的字符宽度。但是名字很奇怪。
     * <p>
     * <p>
     * <p>
     * [java] view plain copy
     * /**
     * Makes the TextView exactly this many ems wide
     *
     * @attr ref android.R.styleable#TextView_ems
     * @android.view.RemotableViewMethod public void setEms(int ems) {
     * mMaxWidth = mMinWidth = ems;
     * mMaxWidthMode = mMinWidthMode = EMS;
     * <p>
     * requestLayout();
     * invalidate();
     * }
     * <p>
     * <p>
     * [html]
     * view plain
     * copy
     * An em
     * is a
     * unit in
     * the field
     * of typography
     * <p>
     * <p>
     * em是一个印刷排版的单位，表示字宽的单位。em字面意思为：
     * equal M   （和M字符一致的宽度为一个单位）简称em。
     * <p>
     * ems是em的复数表达。
     * <p>
     * <p>
     * em 的具体来历？
     * <p>
     * http://en.wikipedia.org/wiki/Em_%28typography%29
     */

    public void a4() {

    }

    /**
     * edittext不获取焦点
     * https://blog.csdn.net/WOSHICAIXIANFENG/article/details/7261718
     * android:focusable="true"
     * android:focusableInTouchMode="true"
     */
    void a5() {

    }


    /**
     * 上传头像图片过大导致 413错误 Request Entity Too Large
     * cropPhotoIntent.putExtra("crop", "true");
     * if(android.os.Build.MODEL.contains("HUAWEI"))
     * {//华为特殊处理 不然会显示圆
     * cropPhotoIntent.putExtra("aspectX", 9998);
     * cropPhotoIntent.putExtra("aspectY", 9999);
     * }
     * else
     * {
     * cropPhotoIntent.putExtra("aspectX", 1);
     * cropPhotoIntent.putExtra("aspectY", 1);
     * }
     * // outputX outputY 是裁剪图片宽高
     * cropPhotoIntent.putExtra("outputX", 300);
     * cropPhotoIntent.putExtra("outputY", 300);
     * <p>
     * 直接调用系统剪裁
     */
    void a6() {
    }


    /**
     * frecso的oom,新闻列表加载图片，都是大图，如何处理？
     * <p>
     * 其实就是加载控件大小的图片即可，或者用glide
     */
    void a7() {
    }


    /**
     * 接入tinker,测试没问题，到正式项目中
     * 出现  but we found loader classes are found in old secondary dex
     * 说明tinker的部分代码在class2.dex中，用 AS的build->Analyze apk来分析
     * 结果真在，网上找方法，说是加 multiDexKeepProguard 来将代码保持在主dex中
     * 但是试了不行。。。不知道哪出了问题。。。
     * <p>
     * 这个时候你只能从原理，分析，Android分包是因为65536，自动将启动需要的代码放入主dex
     * 然后.pro keep规则你也得了解一下。。。看是不是你这写错了，
     * gradle 的规则你也得了解一下 看看 multiDexKeepProguard 是不是写错位置了
     * <p>
     * -----
     * 妈的，气死我了，原来点击右边的 assembleDebug 生成的apk tinker就都在
     * 主dex中，直接run的不行。。。
     */
    void a8() {
    }


    /**
     * java.util.concurrent.TimeoutException: android.os.BinderProxy.finalize() timed out after 10 seconds
     * <p>
     * https://blog.csdn.net/jamin0107/article/details/78793021
     * https://www.jianshu.com/p/0119c682d2b8
     * <p>
     * 屏幕息屏，进程被中断，导致gc超时，抛出异常
     */
    void a9() {

    }


    /**
     * 很多jni的部分我们down下来代码，在sdkManager安装cmake和llbs，
     * 然后需要可能需要 invalidate cache restart ,才能正常
     */
    void a10() {
    }


    /**
     * This file can not be opened as a file descriptor; it is probably compressed
     * 这个问题是aapt打包的时候对资源压缩导致的
     * https://github.com/tensorflow/tensorflow/issues/22333
     * android{
     * aaptOptions {
     * noCompress "tflite"
     * noCompress "lite"
     * }
     */
    void a11() {
    }


    /**
     * Cause: org.jetbrains.plugins.gradle.tooling.util.ModuleComponentIdentifierImpl.getModuleIdentifier()Lorg/gradle/api/artifacts/ModuleIdentifier;
     * <p>
     * classpath 'com.android.tools.build:gradle:3.3.2'
     * distributionUrl=https\://services.gradle.org/distributions/gradle-5.2.1-all.zip
     * <p>
     * 这需要Android studio 版本在3.2以上
     */
    void a12() {
    }


    /**
     * 项目中有jni，这就需要配置ndk，还有tools 中的lldb 和cmake 工具
     * 设置中搜sdk，下载即可，或者直接启动sdk manager
     */
    void a13() {
    }


    /**
     * Could not determine artifacts for XXXX: Skipped due to earlier error
     * <p>
     * https://www.jianshu.com/p/cf2cbd4d005b
     * 仓库的地址请求不到，所以后面的同样的url都失败了
     * <p>
     * 官网上的解释是因为超时的原因，跳过了对同一仓库的请求，这里就比较明显，其实就是代理的问题。
     * 国内开发环境一直是一个比较大问题，开发得一直连着代理，但是由于可能公司有自己的内网maven，所以需要过滤掉内网的Host。但是我这个地方是过滤了的，但是不知道什么原因过滤失败了，而且是部分失败。所以我需要关闭掉代理再来尝试，但是gradle这里有有一些坑了，即使你在IDE中关闭了代理，但是gradle还是会缓存代理的设置，所以需要去Users/xxx/.gradle/gradle.properties中删除掉代理。
     * 然后再进行尝试就ok了。
     */
    void a14() {
    }


    /**
     * 适配的坑，通过头条的适配方案，很完美，但是就一个页面不行，有视频直播，有webview，
     * 检查原因是density被重置了，，然后就debug，找出哪里改变了，发现是setContentView后被重置了
     * 然后这可咋整。。。后来一想为啥之前没事，修改布局后就有事，后来发现原来布局在webview后的大小都错了
     * 那肯定是webview的原因，结果发现就是这个问题（肯定webview中new了一个新的出来），后来解决方案是
     * 动态加入webview，加入后重新设置 density的值，这样就不影响其他布局了
     */
    void a15() {
    }


    /**
     * https://www.jianshu.com/p/57047a84e559
     *
     * Android P(9.0) http网络请求的问题
     * okhttp 出现 CLEARTEXT communication to [ip]  not permitted by network security policy
     * HttpUrlConnection 出现 cleartext HTTP traffic to **** not permitted
     *
     * 在Android P系统的设备上，如果应用使用的是非加密的明文流量的http网络请求，
     * 则会导致该应用无法进行网络请求，https则不会受影响，同样地，如果应用嵌套了webview，webview也只能使用https请求。
     *
     * 有以下三种解决方案
     *
     * APP改用https请求
     *
     * targetSdkVersion 降到27以下
     *
     * 在 res 下新增一个 xml 目录，然后创建一个名为：network_security_config.xml 文件（名字自定） ，内容如下，大概意思就是允许开启http请求
     * <?xml version="1.0" encoding="utf-8"?>
     *
     * <network-security-config>
     *
     *  <base-config cleartextTrafficPermitted="true" />
     *
     * </network-security-config>
     *
     *
     * 然后在APP的AndroidManifest.xml文件下的application标签增加以下属性
     *  android:networkSecurityConfig="@xml/network_security_config"
     *
     */
    void a16(){}


    /**
     * android.view.WindowLeaked: Activity com.tal.brandy.ui.activity.video.VideoActivity has leaked window DecorView@b38aa27[] that was originally added here
     *         at android.view.ViewRootImpl.<init>(ViewRootImpl.java:496)
     *         at android.view.WindowManagerGlobal.addView(WindowManagerGlobal.java:349)
     *         at android.view.WindowManagerImpl.addView(WindowManagerImpl.java:94)
     *         at android.app.Dialog.show(Dialog.java:332)
     *         at com.tal.brandy.ui.dialog.QuitDialog.showDialog
     *  产生原因：
     * 我们知道Android的每一个Activity都有个WindowManager窗体管理器，同样，构建在某个Activity之上的对话框、PopupWindow也有相应的WindowManager窗体管理器。因为对话框、PopupWindown不能脱离Activity而单独存在着，所以当某个Dialog或者某个PopupWindow正在显示的时候我们去finish()了承载该Dialog(或PopupWindow)的Activity时，就会抛Window Leaked异常了，因为这个Dialog(或PopupWindow)的WindowManager已经没有谁可以附属了，所以它的窗体管理器已经泄漏了。
     *
     *
     * 解决方法：
     * 关闭(finish)某个Activity前，要确保附属在上面的Dialog或PopupWindow已经关闭(dismiss)了。
     *
     *
     * ---------------------
     * 作者：u_xtian
     * 来源：CSDN
     * 原文：https://blog.csdn.net/u_xtian/article/details/6123945
     * 版权声明：本文为博主原创文章，转载请附上博文链接！
     *
     *
     *
     */
    void a17(){}


    /**
     * fresco 内存占用问题
     * 是因为setImage 为 null 导致一直请求
     */
    void a18(){}


    /**
     *     Process: com.tal.brandy, PID: 4773
     *     java.lang.UnsupportedOperationException
     *         at java.util.AbstractList.add(AbstractList.java:148)
     *         at java.util.AbstractList.add(AbstractList.java:108)
     *         at java.util.AbstractCollection.addAll(AbstractCollection.java:344)
     *         at com.tal.brandy.ui.activity.video.BaseVideoActivity$11.onUserUpdate(BaseVideoActivity.java:593)
     *         at com.zego.zegoliveroom.ZegoLiveRoom$35.run(ZegoLiveRoom.java:3933)
     *
     */
    void a19(){}
}