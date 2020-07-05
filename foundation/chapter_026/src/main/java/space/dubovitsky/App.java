package space.dubovitsky;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import space.dubovitsky.service.FileManager;
import space.dubovitsky.service.NumberService;

import java.util.Set;

/**
 * Данный класс демонстрирует применение аспектов с Советами(advices) типа - around.
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        FileManager fileManager = (FileManager) context.getBean("fileManager");
        Set<String> extensionList = fileManager.getExtensionList("C:\\Program Files (x86)\\");
        for (String ext : extensionList) {
            System.out.println(ext);
        }

        System.out.println("<<<<<<<<<<<< Number Service >>>>>>>>>>>>>");
        NumberService numberService = (NumberService) context.getBean("numberService");
        System.out.println(numberService.getInt(4634));
    }
}
