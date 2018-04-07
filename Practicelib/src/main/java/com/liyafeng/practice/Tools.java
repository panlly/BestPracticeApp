package com.liyafeng.practice;

import android.content.Context;

/**
 * Created by liyafeng on 16/11/2017.
 */

public class Tools {

    /**
     * 编译打包的过程
     * http://blog.csdn.net/luoshengyang/article/details/8744683
     * http://mouxuejie.com/blog/2016-08-04/build-and-package-flow-introduction/
     */
    void a1(Context context) {
        context.getResources().getDrawable(R.drawable.build_simplified);
        /*
        *
        * */
    }

    /**
     * android studio 目录下build/下的文件夹都是什么作用？
     */
    public void a1_1() {
        /*
        * The "generated" folder contains java code generated by Android Studio for the module. The primary file here is "R.java" which assigns symbolic names to each of the items in the "res" directory so they can be referenced in java source code.

        *The "intermediates" folder contains individual files that are created during the build process and which are eventually combined to produce the "apk" file.
        *
        *The output folder is missing because the module ".iml" file explicitly excludes it with the following statement:
        *
        *<excludeFolder url="file://$MODULE_DIR$/build/outputs" />
        *
        *Remove that line and the "output" directory will appear under build.
        */
    }

    /**
     * android-apt的使用?
     * https://joyrun.github.io/2016/07/19/AptHelloWorld/
     * https://www.jianshu.com/p/2494825183c5
     * https://juejin.im/entry/584a29a5128fe1006c7923a5
     */
    public void a1_2() {
        /*
        * 最早我们用android-apt 这个工具，但是现在已经维护了
        * 因为Gradle推出了官方的处理工具 annotationProcessor
        *
        * Annotation Processing Tool 注解处理工具，用注解来生成代码
        */
        //这是以前的android-apt工具使用
//        buildscript {
//            repositories {
//                jcenter()
//            }
//            dependencies {
//                classpath 'com.neenbedankt.gradle.plugins:android-apt:1.8'
//            }
//        }
//        apply plugin: 'com.neenbedankt.android-apt'
//        dependencies {
//            compile 'org.greenrobot:eventbus:3.0.0'
//            apt'org.greenrobot:eventbus-annotation-processor:3.0.1'//apt
//        }

        //Gradle自带的  annotationProcessor
//        dependencies {
//            compile 'org.greenrobot:eventbus:3.0.0'
//            annotationProcessor  'org.greenrobot:eventbus-annotation-processor:3.0.1'
//        }
    }


    /**
     * 谈谈你对安卓签名的理解?
     * https://blog.csdn.net/jiangwei0910410003/article/details/50402000（signapk.jar源码分析）
     * https://juejin.im/entry/575ed0bb1532bc00609c3aa9
     * https://maoao530.github.io/2017/01/31/apk-sign/
     */
    public void a2(Context context) {
        /*
        * 整个过程用到了SHA-1 的hash算法，和RSA非对称加密
        * 首先签名过程就是在apk(压缩包)中生成一个META-INF文件夹，里面有三个文件
        * MANIFEST.MF  CERT.SF  CERT.RSA 文件，我们就是靠这三个文件来验证apk是没有
        * 被修改过的。
        *   而产生这三个文件的程序就是用 apksigner.jar用xxx.keystore来生成的，
        * xxx.keystore中存储了公钥和私钥 ，而生成xxx.keystore 需要用keytool.jar这个工具
        * keytool -genkeypair -v -keyalg DSA -keysize 1024 -sigalg SHA1withDSA -validity 20000 -keystore D:\xxx.keystore -alias 别名 -keypass 使用密码 -storepass 打包密码？
        * apksigner 签名时用的是pk8和x509.pem文件，xxx.keystore文件可以转化为他们
        * apksigner.jar 源码分析 源码位置：com/android/signapk/sign.java
        * 1，首先生成MANIFEST.MF 文件，apksigner.jar对工程中所有文件的内容做Sha-1计算，
        *   生成摘要信息，然后对摘要进行Base64编码，然后将 name:[文件名] sha1-digest:[摘要]
        *   这个键值对写入文件中。（这样能保证每个文件内容没有被修改过，因为修改了sha1值会变）
        * 2,生成CERT.SF，对MANIFEST.MF 文件做sha1生成摘要信息，然后base64编码
        *   将sha1-digest-manifest:[摘要]写入文件首部
        *   对MANIFEST.MF中的每个“键值对”做sha-1，然后base64编码，写入 name:[key] sha1-digest:[摘要]
         *  （这样就能保证MANIFEST.MF 中的“键值对”没有被修改过）
        * 3，生成CERT.RSA，里面存储了签名使用的算法，公钥信息，然后将CERT.SF和前面的信息用私钥加密
        *   然后写入文件结尾（这样就保证了前面所以文件都不能被修改，因为用公钥解密这个密文，得出
        *   的结果要和之前的信息一致）
        */

        context.getResources().getDrawable(R.drawable.CERT_RSA);
    }

    /**
     * apk反编译的流程？
     * x.509是什么？
     */
    public void a3(Context context) {
        /*
        * ===================反编译查看内容=============================
        * apktool 下载 https://ibotpeaches.github.io/Apktool/install/
        *   反编译出的资源，能查看出Manifest的内容，还有string ,value，layout中的文本
        *   正常解压出来查看是乱码
        *   apk d[ecode] filename
        * dex2jar 下载 https://sourceforge.net/projects/dex2jar/files/
        *    d2j-dex2jar.bat filename.dex 转化为jar包
        * jd-gui http://jd.benow.ca/
        *    点击jd-gui.exe 开启程序，打开上面转化后的jar包，然后就可以查看代码了
        * ===========================从新打包=============================
        * 使用 apktool b[uild] -o new.apk <反编译后的文件夹名称>
        * 这样就生成了 new.apk，但是这种没有 META-INF文件夹，安装会提示失败
        * 因为这个没有签名。
        * 所以我们对它签名，先要生成签名文件，xx.keystore,用keytool这个工具，这个是jdk中的
        * keytool -genkey -alias demo.keystore -keyalg RSA -validity 40000 -keystore demo.keystore
        * 生成了demo.keystore ，然后我们要用jarsigner.exe(也是jdk中的)对apk进行签名
        * jarsigner -verbose -keystore demo.keystore new.apk demo.keystore
        * 这样就在apk中生成了MATE-INF文件夹
        * 然后我们就可以安装了，但是要把之前安装的程序删除，因为我们的签名文件不一样
        * 否则会提示更新冲突，和之前的签名文件不一致，导致安装失败
        *
        * ====================x.509是什么？======================
        * 是一种证书的格式，规定了公钥name:value的一些格式
        */
        context.getResources().getDrawable(R.drawable.CERT_RSA);
    }
}
