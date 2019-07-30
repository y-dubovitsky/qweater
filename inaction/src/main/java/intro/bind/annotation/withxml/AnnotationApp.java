package intro.bind.annotation.withxml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationApp {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("intro/bind.annotation/annotation.xml");

        //Doctor
        Worker worker = (Doctor) app.getBean("doctor");
        worker.doWork();

        //Teacher
        Worker teacher = (StrictTeacher) app.getBean("teacher");
        teacher.doWork();
    }
}
