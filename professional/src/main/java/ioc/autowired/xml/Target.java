package ioc.autowired.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 *  * Тут просто показано как происходит связывание полей и бинов использую xml конфигурирование
 *
 * если в Spring применяется режим
 * byName, то заданное значение устанавливается только в свойстве fooOne, поскольку
 * лишь для него в файле конфигурации задан этот режим автосвязывания. Если же в
 * Spring применяется режим автосвязывания ЬуТуре, то заданные значения устанавливаются во всех трех свойствах целевого компонента.
 * В частности, свойства f ooOne
 * и fooTwo устанавливаются компонентом fooOne, а свойство bar - компонентом
 * barOne. А если применяется режим автосвязывания constructor, то каркас Spring
 * выбирает конструктор с двумя аргументами, потому что он в состоянии предоставить
 * компоненты Spring Beans для обоих его аргументов, не обращаясь к другому конструктору.
 *
 */
public class Target {

    private Foo fooOne;
    private Foo fooTwo;
    private Bar barOne;

    public Target() {}

    public Target(Foo foo) {
        System.out.println("Target(Foo) called");
    }

    public Target(Foo foo, Bar bar) {
        System.out.println("Target(Foo, Bar) called");
    }

    public void setFooOne(Foo fooOne) {
        this.fooOne = fooOne;
        System.out.println("setFooOne " + this.fooOne);
    }

    public void setFooTwo(Foo fooTwo) {
        this.fooTwo = fooTwo;
        System.out.println("setFooTwo " + this.fooTwo);
    }

    public void setBarOne(Bar barOne) {
        this.barOne = barOne;
        System.out.println("setBarOne(Bar barOne)");
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:ioc/autowired/autowired-xml.xml");
        context.refresh();

        Target target = null;

        System.out.println("Using byName:");
        target = (Target) context.getBean("targetByName");

        System.out.println("Using byType:");
        target = (Target) context.getBean("targetByType");

        System.out.println("Using constructor:");
        target = (Target) context.getBean("targetConstructor");
    }

}
