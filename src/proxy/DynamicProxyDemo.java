package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 动态代理:在运行时动态生成代理类。即，代理类的字节码将在运行时生成并载入当前代理的 ClassLoader。
 * 对应设计模式中的代理模式：代理对象 = 增强代码 + 目标对象（原对象）
 * <p>
 * 相比静态代理的好处:
 * 实现无侵入式的代码扩展，也就是方法的增强；让你可以在不用修改源码的情况下，增强一些方法；在方法的前后你可以做你任何想做的事情（甚至不去执行这个方法就可以）。
 * ①不需要为(RealSubject )写一个形式上完全一样的封装类，假如主题接口（Subject） 中的方法很多，为每一个接口写一个代理方法也很麻烦。
 * 如果接口有变动，则目标对象和代理类都要修改，不利于系统维护；
 * ②使用一些动态代理的生成方法甚至可以在运行时制定代理类的执行逻辑，从而大大提升系统的灵活性。
 * <p>
 * 涉及的主要类(java.lang.reflect 包下):
 * ①{@link Proxy} 生成代理类的主类，通过 Proxy 类生成的代理类都继承了 Proxy 类,提供了用户创建动态代理类和代理对象的静态方法，
 * 它是所有动态代理类的父类。
 * Proxy提供了如下两个方法来创建动态代理类和动态代理实例：
 * Ⅰ.static Class<?> getProxyClass(ClassLoader loader, Class<?>... interfaces) 返
 * 回代理类的java.lang.Class对象。第一个参数是类加载器对象（即哪个类加载
 * 器来加载这个代理类到 JVM 的方法区） ，第二个参数是接口（表明你这个代
 * 理类需要实现哪些接口） ，第三个参数是调用处理器类实例（指定代理类中具
 * 体要干什么） ，该代理类将实现interfaces所指定的所有接口，执行代理对象的
 * 每个方法时都会被替换执行InvocationHandler对象的invoke方法。
 * Ⅱ.static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces,
 * InvocationHandler h) 返回代理类实例。参数与上述方法一致。
 * <p>
 * ②{@link InvocationHandler} 是一个接口。当调用动态代理类中的方法时，将会直接转接到执行自定义的InvocationHandler中的invoke()方法。
 * <p>
 * 我们动态生成的代理类需要完成的具体内容需要自己定义一个类，而这个类必须实现 InvocationHandler 接口，
 * 通过重写invoke()方法来执行具体内容。
 */
public class DynamicProxyDemo {

    public static void main(String[] args) {
        // 自动生成代理后的class文件
        System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        // 1.创建目标对象（委托者）
        RealSubject realSubject = new RealSubject();
        // 2.创建调用处理器对象
        ProxyHandler handler = new ProxyHandler(realSubject);
        // 3.动态生成代理对象(被委托者)
        Subject proxySubject = (Subject) Proxy.newProxyInstance(RealSubject.class.getClassLoader(), RealSubject.class.getInterfaces(), handler);
        // 4.通过代理对象调用方法
        proxySubject.request();

        // 输出：
        //before call request.
        //This is RealSubject call request.
        //after call request.
    }

}
