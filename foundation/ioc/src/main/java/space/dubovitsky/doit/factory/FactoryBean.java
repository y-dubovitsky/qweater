package space.dubovitsky.doit.factory;

import space.dubovitsky.doit.annotation.AutoInsert;
import space.dubovitsky.doit.interfaces.Message;
import space.dubovitsky.doit.interfaces.Provider;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Optional;
import java.util.Properties;

/**
 * Класс отвечает за создание компонентов и за автодобавление
 */
public class FactoryBean {

    private static Message message; //! Получается почти как в Спринге, один экземпляр на все приложение
    private static Provider provider;

    public static Message getMessage() {
        return message;
    }

    public static Provider getProvider() {
        return provider;
    }

    static {
        try {
            message = (Message) Class.forName(getProperty("Message")).newInstance();
            provider = (Provider) Class.forName(getProperty("Provider")).newInstance();
            autoInsert(provider); //! Сетает значение благодаря аннотации через рефлексию
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static String getProperty(String name) {
        String result = null;
        try(InputStream inputStream = FactoryBean.class.getClassLoader().getResourceAsStream("factory.properties")) {
            Properties properties = new Properties();
            properties.load(Optional.of(inputStream).orElseThrow());
            result = properties.getProperty(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static void autoInsert(Object object) throws ClassNotFoundException, IllegalAccessException, InstantiationException { //!TODO Через рефлексию сетаем в поле значение, да не гибко, но работает
        Field[] fields = object.getClass().getFields();
        for (Field field : fields) {
            AutoInsert annotation = field.getAnnotation(AutoInsert.class);
            if (annotation != null) {
                //Class<?> type = field.getType();
                //String canonicalName = type.getCanonicalName(); //! Но тут тип Интерфейс, значит нужно в контексте искать тип интерфейса и инжектить? Можно хранить все 'Бины в коллекции'
                if (object instanceof Provider) {
                    Provider provider = (Provider) object;
                    //Object o = Class.forName(canonicalName).newInstance();
                    provider.setMessage(message); //TODO Можно из аннотаци получить тип метода и внедрить
                }
            }
        }
    }
}
