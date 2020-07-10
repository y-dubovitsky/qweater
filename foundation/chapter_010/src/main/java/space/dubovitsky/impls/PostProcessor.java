package space.dubovitsky.impls;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class PostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException");
        System.out.println(beanName);
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException");
        System.out.println(beanName);
        return null;
    }
}
