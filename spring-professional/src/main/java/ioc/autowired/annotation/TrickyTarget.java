package ioc.autowired.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class TrickyTarget {

    /**
     * Указан интерфейс в качестве типа, чтобы можно было создавать два бина одного типа
     * и тем самым "запутать" приложение!
     */
    Fooable fooOne;
    Fooable fooTwo;
    Bar bar;

    public TrickyTarget() {
        System.out.println("TrickyTarget()");
    }

    public TrickyTarget(Fooable foo) {
        System.out.println("TrickyTarget(Foo foo)");
    }

    public TrickyTarget(Fooable foo, Bar bar) {
        System.out.println("TrickyTarget(Foo foo, Bar bar)");
    }

    @Autowired
    public void setFooOne(Fooable fooOne) {
        this.fooOne = fooOne;
        System.out.println("public void setFooOne(Foo fooOne) " + this.fooOne);
    }

    @Autowired
    @Qualifier("fooB")
    public void setFooTwo(Fooable fooTwo) {
        this.fooTwo = fooTwo;
        System.out.println("public void setFooTwo(Foo fooTwo) " + this.fooTwo);
    }

    @Autowired
    public void setBar(Bar bar) {
        this.bar = bar;
        System.out.println("public void setBar(Bar bar)");
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:ioc/autowired/annotation/annotation-xml.xml");
        context.refresh();

        TrickyTarget target = (TrickyTarget) context.getBean(TrickyTarget.class);
        context.close();
    }
}
