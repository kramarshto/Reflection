import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Properties;

public class Injector {
    public Properties prop;

    {
        prop = (new Props("src/main/resources/config.properties")).getProp();
    }

    public <T> T inject(T object) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Class<? extends Object> cl = object.getClass();
        Field[] fl = cl.getDeclaredFields();
        for (Field f : fl) {
            Annotation a = f.getAnnotation(AutoInjectable.class);
            f.setAccessible(true);
            if (a != null) {
                String typeName = prop.getProperty(f.getType().getName());
                Object classObject = Class.forName(typeName).newInstance();
                f.set(object, classObject);
            }
        }
        return object;
    }
}