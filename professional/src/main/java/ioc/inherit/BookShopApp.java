package ioc.inherit;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * В этом классе показывается, как используется два разных КОНТЕКСТА и два разных .xml
 */
public class BookShopApp {
    public static void main(String[] args) {
        // parent
        GenericXmlApplicationContext parent = new GenericXmlApplicationContext();
        parent.load("classpath:ioc/inherit/parent.xml");
        parent.refresh();

        // child
        GenericXmlApplicationContext child = new GenericXmlApplicationContext();
        child.load("ioc/inherit/child.xml");
        child.setParent(parent);
        child.refresh();

        // get books
        Book book1 = (Book) child.getBean("book1");
        System.out.println(book1.getName());
        Book book2 = (Book) child.getBean("book2");
        System.out.println(book2.getName());
        Book book3 = (Book) child.getBean("book3");
        System.out.println(book3.getName());
    }
}
