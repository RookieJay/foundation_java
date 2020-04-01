package pers.jay.foundation.collection;

import java.util.ArrayList;

public class ListDemo {

    public static void main(String[] args) {

    }

    /**
     * ArrayList是一个相对来说比较简单的数据结构，最重要的一点就是它的自动扩容，
     * 可以认为就是我们常说的“动态数组”。
     */
    private void arrayList() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("111");
        list.add("222");
        list.add("333");
        list.remove(0);
        System.out.println(list);
    }


}
