package com.liyafeng.buildtool;

public class Gradle_Maven {
    /**
     * 2017 年google 后，Android studio 版本更新至3.0，更新中，
     * 、连带着com.android.tools.build:gradle 工具也升级到了3.0.0，
     * 在3.0.0中使用了最新的Gralde 4.0 里程碑版本作为gradle 的编译版本，
     * 该版本gradle编译速度有所加速，更加欣喜的是，完全支持Java8。当然，对于Kotlin的支持，
     * 在这个版本也有所体现，Kotlin插件默认是安装的。
     * ---------------------
     * 作者：迦蓝叶
     * 来源：CSDN
     * 原文：https://blog.csdn.net/soslinken/article/details/73114637
     * 版权声明：本文为博主原创文章，转载请附上博文链接！
     *
     *
     * =========api 和 implementation 区别==========
     * api和implement区别
     * api完全等于compile，implement依赖的包只能在本模块中引用到
     * 而api可以任何模块中使用
     *
     * @param args
     */
    public static void main(String[] args) {

    }

    /**
     * ===========什么是maven===========
     * https://maven.apache.org/
     * https://maven.apache.org/what-is-maven.html （什么是maven）
     * Apache Maven is a software project management and comprehension tool.
     * Based on the concept of a project object model (POM),
     * Maven can manage a project's build, reporting and documentation from a central piece of information.
     * maven是一个软件，是java写的，它用来构建，发布，工程 从maven仓库
     * Apache Maven是一个项目管理和理解工具，它基于项目对象模型(POM)的概念，它可以管理项目的构建、报告和文档
     *
     * 一个项目生命周期(Project Lifecycle)，一个依赖管理系统(Dependency Management System)，
     * 能帮你构建工程，管理jar包，编译代码，还能帮你自动运行单元测试，打包，生成报表，甚至能帮你部署项目，生成Web站点
     *
     * ================maven能做什么================
     * 1.项目自动化编译部署：
     * 2.项目jar包的依赖管理： 自动下载项目需要的jar，还可以自动上传项目构建好的jar
     * 3.企业开发分包分模块部署：
     *
     * ======================maven仓库===============
     * https://www.runoob.com/maven/maven-repositories.html
     *
     * 支持maven工具下载jar包的网站，叫maven仓库，他们目录中有 .pom文件，所以支持maven工具下载
     *
     * 本地的仓库地址 ~/.m2/repository   下载的依赖库都在这， ~代表用户目录
     * 默认的远程库 ()https://repo1.maven.org/maven2/
     * 阿里云镜像的maven仓库  http://maven.aliyun.com/nexus/content/groups/public/
     * google的仓库 as3.0之前
     *  maven {
     *             url "https://maven.google.com"
     *  }
     *  之后
     *  allprojects {
     *     repositories {
     *         google()  // add google() before jcenter()
     *         jcenter()
     *     }
     * }
     *
     *
     * 阿里云有很多国外仓库的镜像 https://maven.aliyun.com/mvn/view
     * jcenter (https://maven.aliyun.com/repository/jcenter)
     * maven central (https://maven.aliyun.com/repository/central)
     * Google的 （ https://maven.aliyun.com/repository/google ）
     *
     * ---------Failed to resolve common open file gradle.build---------
     * https://stackmirror.com/questions/50786296
     * 主要是顺序不对  add google() before jcenter()
     * 好像是缓存问题。。
     *
     *
     * -------------------
     * （maven仓库列表）https://mvnrepository.com/repos
     *
     *  maven工具可以从下面的网站上下载jar
     *
     * http://jcenter.bintray.com/
     * http://central.maven.org/maven2/
     * jitpack.io
     * ==================mavenCenter仓库===============
     * maven中央仓库（http://repo1.maven.org/maven2/）是由Sonatype公司提供的服务，它是Apache Maven、SBT和其他构建系统的默认仓库，
     * 并能很容易被Apache Ant/Ivy、Gradle和其他工具所使用。
     * 开源组织例如Apache软件基金会、Eclipse基金会、JBoss和很多个人开源项目都将构件发布到中央仓库。
     * maven中央仓库已经将内容浏览功能禁掉了，可在http://search.maven.org/查询构件。
     *
     *
     * ================jcenter(仓库)是什么 =============
     * https://www.geekhub.cn/a/1295.html（JCenter是什么？）
     * 他是一个maven仓库
     * 它是由 JFrog 公司提供的 Bintray 中的 Java 仓库。它是当前世界上最大的 Java 和 Android 开源软件构件仓库。
     * 所有内容都通过内容分发网络（CDN）使用加密https连接获取。JCenter是Goovy Grape内的默认仓库，Gradle内建支持（jcenter()仓库），
     * 非常易于在（可能除了Maven之外的）其他构建工具内进行配置。
     * 与 Maven Central 相比，JCenter 的速度更快，包含的库更多，UI界面更友好，更容易使用，
     * 同时 Bintray 还支持将 JCenter 上传到 Maven Central 的功能。
     *
     *
     *
     *
     * ===========总结=========
     * maven是一个工具，可以构建和发布项目，和管理项目依赖的依赖库
     * maven仓库 是存jar/aar包的地方，构建工具(Ant、Gradle、maven)可以从这里下载jar包
     * jcenter和mavenCentral都是一种maven仓库
     *
     * 构建和依赖管理工具：Ant Gradle Maven
     * 构建工具下载jar/aar包的地方(maven仓库): jcenter ，mavenCentral
     *
     */
    void a0(){}


    /**
     * 项目打包成aar文件
     * ===============
     * 1.打包之后生成的文件地址：
     *
     * *.jar：库/build/intermediates/bundles/debug(release)/classes.jar
     * *.aar：库/build/outputs/aar/libraryname.aar
     * ---修改编译配置--
     * 1.将apply plugin: ‘com.android.application’改为apply plugin: ‘com.android.library’
     * 2.去掉applicationId
     *-----修改清单文件---
     * 3.清单文件AndroidManifest.xml
     * 将application的name icon lable theme roundIcon等属性去掉
     * .去掉软件的入口（AndroidManifest中的启动intent），如果不去掉，引用此aar文件后，运行时软件有两个图标
     * -----------
     * 运行右侧 gradle ->[module]->build->assemble 就能在目录中找到aar包了
     *
     *
     * =======集成aar包==========
     * android {
     * repositories {
     *     flatDir {
     *         dirs 'libs'
     *     }
     * }
     * }
     * compile(name: 'app-debug', ext: 'aar')
     *
     * -----------------
     *  引入aar包
     *  我们需要在build.gradle(module下的) 中最外层加入
     *
     *  repositories {
     *      flatDir {
     *          dirs 'libs'
     *      }
     *  }
     *  表示repositories 库的目录是 平行目录下的libs文件夹
     *
     *  然后在
     *  dependencies {
     *      implementation fileTree(dir: 'libs', include: ['*.jar']) //这个是代表引入lib中的jar包
     *      implementation(name: 'testlibrary-release', ext: 'aar')
     *   }
     * ===============查看arr内容======
     * 其实想要查看AAR文件里面的内容很简单，只需要将文件名的后缀由".aar" 改为".zip", 然后再解压zip文件即可。
     * 或者用jd-gui也可以查看aar包
     * 内容：
     * aidl
     * assets  assets/fonts
     * jni
     * libs
     * res  (layout,values)
     * AndroidManifest.xml
     * R.txt
     * classes.jar
     *
     *
     */
    void a4(){}





    /**
     * Gradle下载的 jar或aar在哪？
     * https://www.zhihu.com/question/40900206
     *
     * Mac系统默认下载到：/Users/(用户名)/.gradle/caches/modules-2/files-2.1
     * Windows系统默认下载到：C:\Users\(用户名)\.gradle\caches\modules-2\files-2.1
     *
     * 或者
     * 视图切换到Project，最下面有External Libraries，里面是这个项目依赖的库，
     * 右键-》Library Properties 就能查看到目录了，如果是在工程中直接依赖的库，就不会显示路径
     *
     *
     * =======gradle的下载位置========
     * ~/.gradle/wrapper/dists/gradle-2.14.1-all/...
     * ~代表用户跟目录，
     * Mac:  /Users/(用户名)/
     * Windows: C:\Users\(用户名)\
     *
     * ============api implement 下载的内容============
     * 里面有
     * [项目名]-[version].pom 代表这个项目所需的依赖库
     * [项目名]-[version]-sources.jar源码
     * [项目名]-[version].aar classes.jar 资源文件  AndroidManifest.xml等
     *
     */
    void a5(){}


    /**
     * =====什么是aapt==========
     * https://developer.android.google.cn/studio/command-line/aapt2
     *
     * aapt(Android Asset Packaging Tool)
     * 编译和打包资源文件成一个二进制文件用的
     *  compile and package your app’s resources.
     *  AAPT2 parses, indexes, and compiles the resources into a binary format
     *  that is optimized for the Android platform.
     *
     *
     *
     *
     */
    void a6(){}


}
