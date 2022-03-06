# flutter_inappwebview_demo
修复flutter_inappwebview插件一些问题后能正常使用的演示Demo
## 运行环境
`提示：null-safe环境`
```
[✓] Flutter (Channel stable, 2.8.1, on macOS 12.0.1 21A559 darwin-x64, locale zh-Hans-CN)
[✓] Android toolchain - develop for Android devices (Android SDK version 31.0.0)
[✓] Xcode - develop for iOS and macOS (Xcode 13.1)
[✓] Chrome - develop for the web
[✓] Android Studio (version 2021.1)
```
## 演示图
|![1](https://github.com/dushiling/project_image/blob/main/flutter_inappwebview_demo/granted.gif)|![2](https://github.com/dushiling/project_image/blob/main/flutter_inappwebview_demo/forbid.gif)|
| :--: | :--: |
|授权|禁止|

## 错误提示
如果允许出现如下错误：
![1](https://github.com/dushiling/project_image/blob/main/flutter_inappwebview_demo/error.jpg)


```
主要原因是：

Android Gradle插件需要了解新的清单元素，特别是清单合并过程。如果该插件在明显的合并中看到它不认识的元素，就会感到困惑，从而像问题中的错误一样掉出构建错误。

在这种情况下，Android 11引入了<queries>作为清单元素，而旧版本的Android Gradle插件不知道该元素。

这发生在明显的合并中，这意味着仅仅升级依赖项就可能带来这个错误。例如，如果您升级到最新版本的com.awesome:awesome-library，并且其清单中包含<queries>元素，即使代码中没有任何其他更改，您也可能在构建中出现上述错误。

谷歌发布了一系列Android Gradle插件的补丁版本来解决这个问题：

3.3.3
3.4.3
3.5.4
3.6.4
4.0.1
如果您正在使用3.3.*至4.0.*系列中的现有插件，请从该列表中升级到关联的补丁版本（或更高版本），则不应再遇到该错误（例如classpath 'com.android.tools.build:gradle:4.0.1'）。

如果您使用的是Android Studio 4.1或更高版本，并且使用匹配的Android Gradle插件（例如，在4.1.*系列中），您应该没有任何更改。这些插件版本已经知道<queries>。
```


请在如下位置修改gradle版本至合适的补丁版本（我的环境是由3.5.0改到了3.5.4）：
![1](https://github.com/dushiling/project_image/blob/main/flutter_inappwebview_demo/gradle.jpg)

详情请查看这篇文章：[How to fix "unexpected element <queries> found in <manifest>" error?](https://stackoverflow.com/questions/62969917/how-to-fix-unexpected-element-queries-found-in-manifest-error/62969918#62969918)


## 操作说明
请查看我的文章：
- [flutter_inappwebview的使用与问题解决方案](https://www.jianshu.com/p/bf0707988afc)
