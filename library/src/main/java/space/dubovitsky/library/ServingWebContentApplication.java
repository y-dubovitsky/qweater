package space.dubovitsky.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class ServingWebContentApplication extends SpringBootServletInitializer { //! Наследование для запуска механизмов Web и MVC

    public static void main(String[] args) {
        SpringApplication.run(ServingWebContentApplication.class, args);
    }

}