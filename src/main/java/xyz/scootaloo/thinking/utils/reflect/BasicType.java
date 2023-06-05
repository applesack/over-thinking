package xyz.scootaloo.thinking.utils.reflect;

import java.util.List;

/**
 * @author AppleSack
 * @since 2023/06/04
 */
public class BasicType {

    public static final TypeTemplate STRING = new StringTemplate();

    @SuppressWarnings({ "unchecked" })
    private static <T> T takeAs(Object obj, Class<T> type) {
        if (obj == null) {
            return null;
        }
        if (obj.getClass().isAssignableFrom(type)) {
            return (T) obj;
        }
        throw new IllegalArgumentException(String.format("%s must be instances of %s", obj, type));
    }

    private static class StringTemplate implements TypeTemplate {
        @Override
        public Class<?> type() {
            return String.class;
        }

        @Override
        public String qualifiedName() {
            return null;
        }

        @Override
        public TypeInstance construct(List<Object> args) {
            assert args != null && args.size() > 0;
            String stringValue = takeAs(args.get(0), String.class);
            StringInstance instance = new StringInstance();
            instance.setField("", stringValue);
            return instance;
        }
    }

    private static class StringInstance implements TypeInstance {
        private String value;

        @Override
        public TypeTemplate template() {
            return STRING;
        }

        @Override
        public void setField(String fieldName, Object value) {
            this.value = takeAs(value, String.class);
        }

        @Override
        public Object getField(String fieldName) {
            return value;
        }

        @Override
        public Object getInstance() {
            return value;
        }
    }
}
