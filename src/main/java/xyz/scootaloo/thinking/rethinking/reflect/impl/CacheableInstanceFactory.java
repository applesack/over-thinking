package xyz.scootaloo.thinking.rethinking.reflect.impl;

import xyz.scootaloo.thinking.rethinking.reflect.InstanceFactory;
import xyz.scootaloo.thinking.rethinking.reflect.TypeDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * @author AppleSack
 * @since 2023/06/09
 */
public class CacheableInstanceFactory implements InstanceFactory {
    private final Map<String, TypeDefinition> definitionMap = new HashMap<>();

    @Override
    public <T> T getInstance(Class<T> type, Object arg) {
        return null;
    }

    @Override
    public void registerStructure(String qualifiedName, TypeDefinition definition) {
        definitionMap.put(qualifiedName, definition);
    }

    @Override
    public TypeDefinition getDefinition(String qualifiedName) {
        return definitionMap.get(qualifiedName);
    }
}
