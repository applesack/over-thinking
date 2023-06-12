package xyz.scootaloo.thinking.rethinking.reflect;

import java.util.Objects;

/**
 * @author AppleSack
 * @since 2023/06/09
 */
public class Construction {

    public static Object construct(Class<?> classType, Object arg) {
        if (Objects.isNull(arg)) {
            return null;
        }
        var typeDef = resolveTypeDef(classType);
        return instantiateWithArg(typeDef, arg);
    }

    private static TypeDefinition resolveTypeDef(Class<?> classType) {
        return Deconstruction.deconstruct(classType);
    }

    private static Object instantiateWithArg(TypeDefinition typeDef, Object arg) {
        var instance = typeDef.newInstance();
//        Deconstruction.TypeMark.isBasicType()
        return instance;
    }
}
