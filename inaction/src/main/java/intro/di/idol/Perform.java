package intro.di.idol;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Perform {
    public static void main(String[] args) throws Exception{
        ApplicationContext ap = new ClassPathXmlApplicationContext("di/idol/config.xml");

        Performer performer = (Juggler) ap.getBean("duke");
        performer.perform();

        Performer performer1 = (PoeticJuggler) ap.getBean("poeticDuke");
        performer1.perform();

        Performer kenny = (Instrumentalist) ap.getBean("kenny");
        kenny.perform();

        Performer manBand = (OneManBand) ap.getBean("oneManBand");
        manBand.perform();

        Performer rockBand = (RockBand) ap.getBean("rockBand");
        rockBand.perform();

        Performer carl = (CarlInstrumentalist) ap.getBean("carl");
        carl.perform();
    }
}
