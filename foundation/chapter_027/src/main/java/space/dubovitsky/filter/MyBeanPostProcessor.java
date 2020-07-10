package space.dubovitsky.filter;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.err.println("BeforeInitialization : " + beanName + " " + bean.getClass().getCanonicalName());
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.err.println("AfterInitialization : " + beanName + " " + bean.getClass().getCanonicalName());
        return null;
    }
}
