package space.dubovitsky.data;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDataApp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:app-context.xml");
        context.refresh();

        context.getBean("courseService"); //! TODO Не работает. Переделать на java-config
    }

}
