package ioc.naming.xml;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.beans.factory.annotation.Qualifier;
        import org.springframework.context.support.GenericXmlApplicationContext;
        import org.springframework.stereotype.Component;

/**
 * In this class injected components from .xml
 * Короче, этот класс создан для демонстрации того, как можно или нельзя использовать компоненты
 * без имен или с разными вариациями имен.
 */
@Component("injection")
class ClassForInjection {

    private String string;

    public void doAction() {
        System.out.println(string);
    }

    /**
     * Если не применять @Qualifier(value = "name"), то при существующей конфигурации .xml
     * Spring не сможет внедрить компонент!
     * @param string
     */
    @Autowired
    @Qualifier(value = "name")
    public void setString(String string) {
        this.string = string;
    }
}

public class NamingDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:ioc/naming/context-xml.xml");
        context.refresh();

        ClassForInjection c = (ClassForInjection) context.getBean("injection");
        c.doAction();
    }
}


