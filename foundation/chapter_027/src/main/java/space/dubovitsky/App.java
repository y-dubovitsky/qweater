package space.dubovitsky;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import space.dubovitsky.service.FileService;

/**
 * Аннотации для аспектов:
 */
public class App {
    public static void main( String[] args ) throws Exception{
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        FileService fileService = (FileService) context.getBean("fileService");
        fileService.fileAbsolutePath("C:/");
        fileService.fileInfo("D:\\Фильмы\\Научные");
        fileService.getTree("D:\\Фильмы\\Научные");
    }
}
