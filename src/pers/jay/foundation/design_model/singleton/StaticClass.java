package pers.jay.foundation.design_model.singleton;

/**
 * 静态内部类(static nested class),线程安全
 * 由于 SingletonHolder 是私有的，除了 getInstance() 之外没有办法访问它，因此它
 * 是懒汉式的；同时读取实例的时候不会进行同步，没有性能缺陷；也不依赖 JDK
 * 版本。
 */
public class StaticClass {

    private static class SingletonHolder {
        private static final StaticClass instance = new StaticClass();
    }

    private StaticClass(){}

    private StaticClass getInstance() {
        return SingletonHolder.instance;
    }

}
