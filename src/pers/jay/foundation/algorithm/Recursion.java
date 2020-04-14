package pers.jay.foundation.algorithm;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Recursion {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        // 斐波那契数列求第n项
//        System.out.println(fibonacii1(8));
        // 找指定目录下所有文件
        findDirFiles();
        long end = System.currentTimeMillis();
        System.out.println("耗时" + (end - start) + "ms");
    }

    /**
     * 案例一、斐波那契数列求第n项递归算法
     * 算法的时间复杂度随着N的增大呈现指数增长，为O(2^n)
     * @param n
     */
    private static int fibonacii1(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            // 这里return什么取决于前两项是什么
            return 1;
        }
        return fibonacii1(n - 1) + fibonacii1(n - 2);
    }

    /**
     * 案例一、斐波那契数列求第n项循环求法
     * 时间复杂度O(n)
     * @param n
     * @return
     */
    private static int fibonacii2(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }
        int a1 = 1;
        int a2 = 1;
        int a3;
        for (int i = 3; i < n + 1; i++){
            a3 = a1 + a2;
            a1 = a2;
            a2 = a3;
        }
        return a2;
    }


    /**
     * 案例二、找指定目录下所有文件
     */
    public static void findDirFiles() {
        String path = "E:\\Android-Develop\\Git知识";
        File dir = new File(path);
        if (!dir.exists()) {
            System.out.println("指定目录不存在");
            return;
        }
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            System.out.println("指定目录下没有文件");
            return;
        }
        List<File> list = getFiles(dir);
        for (File file : list) {
            System.out.println(file.getAbsolutePath());
        }
    }

    /**
     * 案例三
     * 等差数列求和
     */
    public void arithSeq() {

    }

    /**
     *
     * @param file
     * @return
     */

    private static List<File> getFiles(File file) {
        List<File> fileList = new ArrayList<>();
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                fileList.addAll(getFiles(f));
            }
        } else {
            fileList.add(file);
        }
        return fileList;
    }


}
