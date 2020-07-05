package config_loading.destroy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean(initMethod = "firstInit")
    public Car firstCar() {
        return new Car();
    }

    @Bean(initMethod = "secondInit", destroyMethod = "destroy")
    public Car secondCar() {
        return new Car();
    }

}
