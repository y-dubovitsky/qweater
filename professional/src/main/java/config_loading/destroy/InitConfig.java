package config_loading.destroy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InitConfig {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        Car first = context.getBean("firstCar", Car.class);
        Car second = context.getBean("secondCar", Car.class);

        // before destroy
        System.out.println(second == null);
        System.out.println(first == null);

        context.destroy();

        // after destroy
        System.out.println(second == null);
        System.out.println(first == null);
    }
}
