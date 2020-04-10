package pers.jay.foundation.collection.map;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

    /**
     * initialCapacity = 需要储存的元素个数 / 负载因子(loaderFactor，默认为0.75) + 1
     * 设置初始容量，提高性能，暂时无法确定初始值大小，设置16
     * 默认情况下，当我们设置HashMap的初始化容量时，实际上HashMap会采用第一个大于该数值的2的幂作为初始化容量。
     * 比如设置1输出2，设置5输出8
     */
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>(5);
        map.put(1, 2);
        Class<?> mapType = map.getClass();
        try {
            Method capacityMethod = mapType.getDeclaredMethod("capacity");
            // 设置可访问
            capacityMethod.setAccessible(true);
            System.out.println("capacity = " + capacityMethod.invoke(map));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
