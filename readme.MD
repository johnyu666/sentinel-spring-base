# 简单的将Sentinel 与 Springboot 集成
## 一、项目的目标：
与sentinel-base 项目相同，都只是为了演示 Sentinel 的工作原理
## 二、代码说明：
1. 项目中应用了 @SentinelResource 进行资源的定义，同时指定了block和fallback的降级。
2. 需要注意 @SentinelResource 注解的使用，一定要配置SentinelResourceAspect，为此需要引入
sentinel-annotation-aspectj
3. 将规则与资源的绑定，添加到了容器的启动事件处理器中
4. 使用 index.html 进行 ajax方式的测试