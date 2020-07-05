package config_loading.destroy;

import org.springframework.context.support.GenericXmlApplicationContext;

public class InitXml {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:config_loading/destroy/context-dest-xml.xml");
        context.refresh();

        Car first = context.getBean("firstCar", Car.class);
        Car second = context.getBean("second", Car.class);
        context.destroy();
    }
}
