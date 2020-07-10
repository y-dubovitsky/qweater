package ioc.visible;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * 8 Поток исполнения. Каркас Spring получит новый экземпляр компонента
 * Spring Bean по запросу из нового потока исполнения. А по запросу из одного и
 * того же потока исполнения возвратится тот же самый экземпляр компонента
 * Spring Bean. Однако эта область видимости не регистрируется по умолчанию.
 *
 * Тут я пытался получить два разных объекта используя второй поток исполнения! Но не получилось,
 * наверное потому что использовал один и тот же контекст
 */
public class VisibleScopeExample {

    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("ioc/visible/visible-context-xml.xml");
        context.refresh();

        Runnable runnable = () -> {
            Player player1 = context.getBean("Rampage", Player.class);
            System.out.println(player1);
        };

        Thread thread = new Thread(runnable);
        thread.start();

        Player player2 = context.getBean("Rampage", Player.class);
        System.out.println(player2);

        Player player3 = context.getBean("Rampage", Player.class);
        System.out.println(player3);
    }

}
