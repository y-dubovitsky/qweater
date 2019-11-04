package ioc.config_with_xml;

import ioc.config_with_xml.config.Config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * In this app we will show you how to use java configuration class with xml and annotation;
 */
public class StartApp {
    public static void main(String[] args) {
        ApplicationContext ap = new AnnotationConfigApplicationContext(Config.class);
        OutputMessage out = ap.getBean("outMessage", OutputMessage.class);
        out.outMessage();
    }
}
