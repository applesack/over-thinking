package xyz.scootaloo.thinking.utils.mark;

import java.lang.annotation.*;

/**
 * @author AppleSack
 * @since 2023/03/22
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Repeatable(Modifies.class)
@Retention(RetentionPolicy.SOURCE)
public @interface Modify {

    String value();

}
