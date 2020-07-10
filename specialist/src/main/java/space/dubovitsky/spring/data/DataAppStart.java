package space.dubovitsky.spring.data;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import space.dubovitsky.spring.data.service.CarService;

public class DataAppStart {

    //! TODO Not work!!!!
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/space/dubovitsky/spring/data/app-context.xml");

        CarService courseDao = context.getBean("carServiceImpl", CarService.class);


    }
}
