package pers.jay.foundation.design_model.singleton;

/**
 * 饿汉式，线程安全。在创建对象实例的时候就比较着急，饿了嘛，于是在装载类的时候就创建对象实例。存在问题：加载类后一开始就会初始化，不调用getInstance也会。
 * 饿汉式的创建方式在一些场景中将无法使用：譬如 HungaryMan 实例的创建是依赖参数或者配置文件的，
 * 在 getInstance() 之前必须调用某个方法设置参数给它，那样这种单例写法就无法使用了。
 */
public class HungaryMan {

    // 在类加载时初始化，线程安全
    private static final HungaryMan instance = new HungaryMan();

    private HungaryMan(){}

    public static HungaryMan getInstance() {
        return instance;
    }

}
