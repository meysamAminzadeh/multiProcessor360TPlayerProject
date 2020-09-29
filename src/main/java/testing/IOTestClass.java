package testing;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation is placed on the class and as an input takes
 * the name of the class to achieve the desired methods in the
 * program.
 *
 * @author Meysam Aminzadeh on 7/31/2020.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface IOTestClass {
    Class<?> main();
}
