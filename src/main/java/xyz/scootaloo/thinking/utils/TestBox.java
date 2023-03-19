package xyz.scootaloo.thinking.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author flutterdash@qq.com
 * @since 2022/09/23 - 10:42
 */
@SuppressWarnings("unused")
public class TestBox {

    private record TestTask(Object instance, Method method, Object[] arguments) {

        private TestTask(Object instance, Method method, Object[] arguments) {
            this.instance = instance;
            this.method = method;
            this.arguments = arguments;

            this.method.setAccessible(true);
        }

        public void execute() throws InvocationTargetException, IllegalAccessException {
            method.invoke(instance, arguments);
        }

    }

}
