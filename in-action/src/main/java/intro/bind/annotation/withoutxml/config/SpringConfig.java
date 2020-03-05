package intro.bind.annotation.withoutxml.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import intro.bind.annotation.withoutxml.*;

/**
 * This class is needed for configuration Spring application;
 * Each method declared as @Bean return Spring-component.
 */
@Configuration
public class SpringConfig {

    @Bean
    public Perform jump() {
        return new Jump();
    }

    @Bean
    public Perform run() {
        Run run = new Run("Forest");
        run.setLenght(100);
        return run;
    }

    @Bean
    public Sportsman jumper() {
        return new Jumper();
    }

    @Bean
    public Sportsman runner() {
        return new Runner();
    }
}
