package di.collection.city;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Method;
import java.util.List;

/**
 * In this class demonstrated how to use <util:list id="cities">, collections
 */
public class StartApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("di/collection/city/collection.xml");
        // return all java.util.List
        List<City> cityList = (List<City>) context.getBean("cities");
        for (City c: cityList) {
            System.out.println(c.getName());
        }
        // return city number 2
        City two = (City) context.getBean("two");
        System.out.println("City number two is.... " + two.getName());
    }
}
