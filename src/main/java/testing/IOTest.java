package testing;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This notation is placed on any method and has the ability
 * to take the name of the file or any other string as input.
 * @author Meysam Aminzadeh on 7/31/2020.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface IOTest {
    String input();
}
