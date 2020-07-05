package config_loading.context;

import org.springframework.beans.factory.BeanNameAware;

/**
 * Обычный класс, который реализует интерфейс BeanNameAware,
 * который возвращает имя бина из контекста.
 */
public class Clazz implements BeanNameAware {

    private String name;

    public Clazz() {
        System.out.println("Hello from default constructor");
    }

    static {
        System.out.println("Hello from static block");
    }

    @Override
    public void setBeanName(String s) {
        this.name = s;
    }

    @Override
    public String toString() {
        return "My name is ... " + this.name;
    }
}
