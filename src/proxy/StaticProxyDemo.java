package proxy;

/**
 * 静态代理：代理类是在编译时就实现好的。也就是说 Java 编译完成后代理类是一个实际的 class 文件。
 *
 * 委托类：{@link RealSubject}
 * 代理类：{@link RealSubjectProxy}
 *
 * 代理类和委托类通常会实现相同的接口，代理解决的问题当两个类需要通信时，引入第三方代理类，将两个类的关系解耦，让我们只了解代理类即可，
 * 而且代理的出现还可以让我们完成与另一个类之间的关系的统一管理，但是切记，代理类和委托类要实现相同的接口，因为代理真正调用的还是委托类的方法。
 */
public class StaticProxyDemo {

    public static void main(String[] args) {
        RealSubjectProxy proxy = new RealSubjectProxy(new RealSubject());
        proxy.request();
        // 输出：
        // before call request.
        // This is RealSubject call request.
        // after call request.
    }

}
