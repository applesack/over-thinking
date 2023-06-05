package xyz.scootaloo.thinking.utils.reflect;

import java.util.List;

/**
 * @author AppleSack
 * @since 2023/06/04
 */
public interface TypeTemplate {

    Class<?> type();

    String qualifiedName();

    TypeInstance construct(List<Object> args);
}
