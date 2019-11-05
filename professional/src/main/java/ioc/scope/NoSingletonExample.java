package ioc.scope;

import org.springframework.context.support.GenericXmlApplicationContext;

public class NoSingletonExample {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("ioc/scope/scope-context-xml.xml");
        context.refresh();

        // annotated config
        Singer singer1 = context.getBean("notSingleton", Singer.class);
        Singer singer2 = context.getBean("notSingleton", Singer.class);

        System.out.println(singer1 == singer2);
        System.out.println(singer1.equals(singer2));

        System.out.println(singer1);
        System.out.println(singer2);

        // xml config
        Musician musician1 = context.getBean("notSingletonMusician", Musician.class);
        Musician musician2 = context.getBean("notSingletonMusician", Musician.class);

        System.out.println(musician1 == musician2);
        System.out.println(musician1.equals(musician2));

        System.out.println(musician1);
        System.out.println(musician2);
    }
}
