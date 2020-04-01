# 自定义注解
## 一、元注解
- **@Documented** 
用户指定被该元Annotation修饰的Annotation类将会被javadoc工具
提取成文档，如果定义Annotation类时使用了 @Documented 修饰，则所有使用该
Annotation修饰的程序元素的API文档中将会包含该Annotation说明。

- **@Inherited** 
指定被它修饰的Annotation将具有继承性——如果某个类使用了
@Xxx注解（定义该Annotation时使用了 @Inherited 修饰） 修饰，则其子类将自
动被@Xxx修饰。

- **@Retention**
表示该注解类型的注解保留的时长。当注解类型声明中没
有 @Retention 元注解，则默认保留策略为RetentionPolicy.CLASS。关于保留策
略(RetentionPolicy)是枚举类型，共定义3种保留策略。
    1. SOURCE:仅存在Java源文件，经过编译器后便丢弃相应的注解。
    2. CLASS:存在Java源文件,及经过编译器后生成的字节码文件，但在运行时VM不再保留注释。
    3. RUNTIME:存在Java源文件,及经过编译器后生成的字节码文件,保留在运行时的VM中，可通过反射性地读取注解。

- **@Target**
表示该注解类型的所适用的程序元素类型。当注解类型声明中没
有 @Target 元注解，则默认为可适用所有的程序元素。如果存在指定
的 @Target 元注解，则编译器强制实施相应的使用限制。关于程序元素
(ElementType)是枚举类型，共定义8种程序元素，详见ElementType枚举类。

## 二、自定义注解
- 创建自定义注解

    与创建接口有几分相似，但注解在interface前需要加@,例如：

```
@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotataion{
    String name();
    String website() default "hello";
    int revision() default 1;
}
```
使用@interface自定义注解时，自动继承了java.lang.annotation.Annotation接口，由编译程序自动完成其他细节。在定义注解时，不能继承其他的注解或接口。
    
- 自定义注解规则

其定义是以无形参的方法形式来声明的。即：
注解方法不带参数，比如name()，website()；
注解方法返回值类型：基本类型、String、Enums、Annotation以及前面这些类型
的数组类型
注解方法可有默认值，比如default "hello"，默认website=”hello”
当然注解中也可以不存在成员变量，在使用解析注解进行操作时，仅以是否包含该
注解来进行操作。当注解中有成员变量时，若没有默认值，需要在使用注解时，指
定成员变量的值。

- 注解参数的可支持数据类型：

    1. 所有基本数据类型（int,float,boolean,byte,double,char,long,short)
    2. String类型
    3. Class类型
    4. enum类型
    5. Annotation类型
    6. 以上所有类型的数组