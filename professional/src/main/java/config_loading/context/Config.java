package config_loading.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean(name = "letsDance")
    public Clazz danceClass() {
        return new Clazz();
    }

}
