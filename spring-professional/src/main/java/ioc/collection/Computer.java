package ioc.collection;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * В этом примере демонстрируется как внедрять значения в поля класса(Коллекции) из xml
 */
public class Computer {

    /**
     * Collections
     */
    private List<Integer> count;
    private Map<String, User> users;
    private Set<Object> set;
    private Properties properties;

    public void setCount(List<Integer> count) {
        this.count = count;
    }

    public void setUsers(Map<String, User> users) {
        this.users = users;
    }

    public void setSet(Set<Object> set) {
        this.set = set;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    /**
     * Display all from the collections
     */
    public void display() {
        System.out.println("Map: ");
        this.users.entrySet().stream()
                .forEach(e -> {
                    System.out.println(e.getKey() + " " + e.getValue().getName());
                });
        System.out.println("List: ");
        this.count.stream()
                .forEach(System.out::println);
        System.out.println("Set: ");
        this.set.stream()
                .forEach(System.out::println);
        System.out.println("Properties: ");
        this.properties.entrySet()
                .forEach(e -> {
                    System.out.println(e.getKey() + " " + e.getValue());
                });
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:ioc/collection/context.xml");
        context.refresh();
        Computer computer = (Computer) context.getBean("ComputerXML");
        computer.display();
    }
}
