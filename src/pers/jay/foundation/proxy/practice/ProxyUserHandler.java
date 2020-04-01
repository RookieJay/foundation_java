package pers.jay.foundation.proxy.practice;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 调用处理器
 */
public class ProxyUserHandler implements InvocationHandler {

    private Action action;

    public ProxyUserHandler(Action action) {
        this.action = action;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 这里判断权限是否通过
        Object o = null;
        if (action instanceof User) {
            try {
                if (((User) action).isHasPrivilege()) {
                    System.out.println("鉴权成功，开始进行查询");
                    o = method.invoke(action, args);
                    System.out.println("用户查询完毕");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("捕获到非法参数异常");
                e.printStackTrace();
            } finally {
                System.out.println("代码执行完毕");
            }
            return o;
        }
        System.out.println("鉴权失败，无法进行查询");
        return null;
    }
}
