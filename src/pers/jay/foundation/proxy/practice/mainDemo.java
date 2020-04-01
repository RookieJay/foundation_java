package pers.jay.foundation.proxy.practice;

import java.lang.reflect.Proxy;

public class mainDemo {

    public static void main(String[] args) {
        // 1.创建目标对象（委托者）
        User user = new User();
        // 模拟数据状态
        user.setHasPrivilege(true);
        user.setS("哈哈哈");
        // 2.创建调用处理器对象
        ProxyUserHandler handler = new ProxyUserHandler(user);
        // 3.动态生成代理对象(被委托者)
        Action action = (Action) Proxy.newProxyInstance(user.getClass().getClassLoader(), user.getClass().getInterfaces(), handler);
        // 4.通过代理对象调用方法
        action.query();
    }
}
