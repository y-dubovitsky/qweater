package di.collection.properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Properties;

/**
 * This class show how to bind .properties and .xml;
 * for more information see settings.xml
 */
public class LoadProperties {

    private String propFromFile;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("di/collection/properties/settings.xml");
        Properties properties = (Properties) context.getBean("setting");
        System.out.println(properties.getProperty("value"));

        // Dont do this.. But why not?
        LoadProperties load = (LoadProperties) context.getBean("loadProp");
        System.out.println(load.propFromFile);
    }

    public String getPropFromFile() {
        return propFromFile;
    }

    public void setPropFromFile(String propFromFile) {
        this.propFromFile = propFromFile;
    }
}
