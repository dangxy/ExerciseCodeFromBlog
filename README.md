# ExerciseCodeFromBlog
## 自定义view

## android中开发应该注意的:

从Futurice公司Android开发者中学到的经验。 遵循以下准则，避免重复发明轮子。若您对开发iOS或Windows Phone 有兴趣， 请看iOS Good Practices 和 Windows client Good Practices 这两篇文章。
摘要
- 使用 Gradle 和它推荐的工程结构
- 把密码和敏感数据放在gradle.properties
- 不要自己写 HTTP 客户端,使用Volley或OkHttp库
- 使用Jackson库解析JSON数据
- 避免使用Guava同时使用一些类库来避免65k method limit（一个Android程序中最多能执行65536个方法）
- 使用 Fragments来呈现UI视图
- 使用 Activities 只是为了管理 Fragments
- Layout 布局是 XMLs代码，组织好它们
- 在layoutout XMLs布局时，使用styles文件来避免使用重复的属性
- 使用多个style文件来避免单一的一个大style文件
- 保持你的colors.xml 简短DRY(不要重复自己)，只是定义调色板
- 总是使用dimens.xml DRY(不要重复自己)，定义通用常数
- 不要做一个深层次的ViewGroup
- 在使用WebViews时避免在客户端做处理，当心内存泄露
- 使用Robolectric单元测试，Robotium 做UI测试
- 使用Genymotion 作为你的模拟器
- 总是使用ProGuard 和 DexGuard混淆来项目

