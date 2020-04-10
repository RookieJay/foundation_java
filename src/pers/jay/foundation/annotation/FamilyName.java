package pers.jay.foundation.annotation;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Target({METHOD, TYPE})
public @interface FamilyName {

    String name() default "Zhou";
}
