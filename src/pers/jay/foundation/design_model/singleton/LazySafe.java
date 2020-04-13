package pers.jay.foundation.design_model.singleton;

/**
 * 线程安全的懒汉式,但是存在问题：同步操作只需要在第一次调用时才被需要，即第一次创建单例实例对象时。每次只能一个线程调用getInstance()，不高效。
 */
public class LazySafe {

    private static LazySafe INSTANCE;

    private LazySafe() { }

    public static synchronized LazySafe getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LazySafe();
        }
        return INSTANCE;
    }
}
