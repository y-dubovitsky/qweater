package ioc.dependencies;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

/**
 * Этот класс зависит от класса Chair!
 */
@Component("kitchenChair")
@DependsOn("chair")
public class Table implements ApplicationContextAware {

    private ApplicationContext context;
    private Chair chair;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public void doAction() {
        context.getBean("chair", Chair.class).moveChair();
    }
}
