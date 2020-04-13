package pers.jay.foundation.design_model.singleton;

/**
 * 懒汉式，线程不安全，当有多个线程并行调用getInstance()时，会产生多个实例，不能正常工作
 */
public class LazyUnsafe {

    private static LazyUnsafe INSTANCE;

    private LazyUnsafe() {}

    public static LazyUnsafe getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LazyUnsafe();
        }
        return INSTANCE;
    }

}
