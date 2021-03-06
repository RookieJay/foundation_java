# 代理模式
## 一、定义

1. 代理模式的理解

- 代理模式使用代理对象完成用户请求，屏蔽用户对真实对象的访问。现实世界的代
理人被授权执行当事人的一些事宜，无需当事人出面，从第三方的角度看，似乎当
事人并不存在，因为他只和代理人通信。而事实上代理人是要有当事人的授权，并
且在核心问题上还需要请示当事人。
在软件设计中，使用代理模式的意图也很多，比如因为安全原因需要屏蔽客户端直
接访问真实对象，或者在远程调用中需要使用代理类处理远程方法调用的技术细
节，也可能为了提升系统性能，对真实对象进行封装，从而达到延迟加载的目的。

- 给某个对象提供一个代理对象，并由代理对象控制对于原对象的访问，即客
  户不直接操控原对象，而是通过代理对象间接地操控原对象。代理类和委托类通常会实现相同的接口，代理解决的问题当两个类需要通信时，引入第三方代理类，将两个类的关系解耦，让我们只了解代理类即可，
  而且代理的出现还可以让我们完成与另一个类之间的关系的统一管理，但是切记，代理类和委托类要实现相同的接口，因为代理真正调用的还是委托类的方法。
 
- 代理对象 = 增强代码 + 目标对象（原对象）

2. 分类

- 静态代理：代理类是在编译时就实现好的。也就是说 Java 编译完成后代理类是一个实际的 class 文件。

- 动态代理：在运行时动态生成代理类。即，代理类的字节码将在运行时生成并载入当前代理的 ClassLoader。

## 二、实现思路

- 代理对象和目标对象均实现同一个行为接口。
- 代理类和目标类分别具体实现接口逻辑。
- 在代理类的构造函数中实例化一个目标对象。
- 在代理类中调用目标对象的行为接口。
- 客户端想要调用目标对象的行为接口，只能通过代理类来操作。


## 三、
