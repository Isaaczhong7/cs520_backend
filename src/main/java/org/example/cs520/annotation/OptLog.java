package org.example.cs520.annotation;

import java.lang.annotation.*;

/**
 * operation log
 * @author Xinyuan Xu, Isaac 
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OptLog {
    /**
     * @return operation type
     */
    String optType() default "";
}
