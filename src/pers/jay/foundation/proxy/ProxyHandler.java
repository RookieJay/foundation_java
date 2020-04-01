package pers.jay.foundation.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyHandler implements InvocationHandler {

    private Subject subject;

    public ProxyHandler(Subject subject) {
        this.subject = subject;
    }

    /**
     * 此方法是在代理对象调用任何一个方法时都会调用的，方法不同会导致第二个参数method不同
     * @param proxy 代理对象（表示哪个代理对象调用了method方法）
     * @param method Method 对象（表示哪个方法被调用了）
     * @param args 指定调用方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before call request.");
        Object object = method.invoke(subject, args);
        System.out.println("after call request.");
        return object;
    }
}
