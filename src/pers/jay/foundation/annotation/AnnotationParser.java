package pers.jay.foundation.annotation;

/**
 * 通过反射技术来解析自定义注解
 * 于反射类位于包java.lang.reflect，其
 * 中有一个接口AnnotatedElement，该接口主要有如下几个实现类：Class，
 * Constructor，Field，Method，Package。除此之外，该接口定义了注释相关的几
 * 个核心方法，如下：
 */
public class AnnotationParser {

    public static void main(String[] args) throws SecurityException {
        System.out.println("父亲姓什么?");
        parseAnnotation(Father.class);
        System.out.println("孩子姓什么?");
        parseAnnotation(Child.class);
    }

    /**
     * 解析clazz实例中的指定注解
     * @param clazz：要传入的clazz对象
     */
    public static void parseAnnotation(Class<?> clazz) {
        //clazz是以FamilyName注解修饰
        if (clazz.isAnnotationPresent(FamilyName.class)) {
            FamilyName annotation = clazz.getAnnotation(FamilyName.class);
            System.out.println(annotation);
            System.out.println(annotation.name());
        }
    }

}
