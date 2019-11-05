package ioc.dependencies;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * This class depends on other class(Sex.class) and use ApplicationContext
 */
public class Human implements ApplicationContextAware {

    private String name;
    private Sex sex;
    private ApplicationContext context;

    public Human(String name) {
        this.name = name;
    }

    public void say() {
        sex = context.getBean("sex", Sex.class);
        System.out.println("This human is " + name + " male");
        sex.doAction();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
