package config_loading.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Применение интерфейса BeanNameAware
 * В интерфейсе BeanNameAware, который компонент Spring Bean может реализовать, чтобыполучитьсвоеимя,определен единственный мeтoдsetBeanName (String).
 *
 * Этот интерф. содержит только 1 метод, который получает ИМЯ бина из контекста или  конфигурации
 */
public class NamedClazz {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext config = new AnnotationConfigApplicationContext(Config.class);
        Clazz c = config.getBean("letsDance", Clazz.class);
        System.out.println(c);
    }
}
