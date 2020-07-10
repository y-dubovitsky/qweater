package ioc.autowired.config_class;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Получается если я в конфиг файле указываю все аннотации, то сами классы я могу не аннотировать
 * т.е. я могу просто оставить public class FooA implements Fooable {} без @Component и @Primary
 */
@Configuration
public class ConfigClass {

    @Bean
    @Primary
    public Fooable fooA() {
        return new FooA();
    }

    @Bean
    public Fooable fooB() {
        return new FooB();
    }

    @Bean
    public Bar bar() {
        return new Bar();
    }

    // Не забывай объявлять ВСЕ БИНЫ!
    @Bean
    public TargetConfigDemo targetConfigDemo() {
        return new TargetConfigDemo();
    }
}
