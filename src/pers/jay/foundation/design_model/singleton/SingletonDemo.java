package pers.jay.foundation.design_model.singleton;

public class SingletonDemo {

    public static void main(String[] args) {
        test();
    }

    private static void test() {
        for (int i = 0; i < 200; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+":"+LazyUnsafe.getInstance().hashCode());
                }
            }).start();
        }
    }



}
