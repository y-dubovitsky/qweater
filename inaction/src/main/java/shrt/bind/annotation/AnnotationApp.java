package shrt.bind.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationApp {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("shrt/bind.annotation/annotation.xml");
        Worker worker = (Doctor) app.getBean("doctor");
        worker.doWork();
    }
}
