package pers.jay.foundation.design_model.singleton;

/**
 * 我们可以通过EnumSingleton.INSTANCE来访问实例，这比调用getInstance()方法简单多了。
 * 创建枚举默认就是线程安全的，所以不需要担心double checked locking，而且还能防止反序列化导致重新创建新的对象。
 */
public enum  EnumSingleton {

    INSTANCE;

}
