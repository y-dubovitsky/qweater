package di.idol.instruments;

import di.idol.instruments.Instrument;

public class Piano implements Instrument {

    @Override
    public void play() {
        System.out.println("<bean id=\"kenny\"\n" +
                "class=\"com.springinaction.springidol.Instrumentalist\">\n" +
                "<property name=\"song\" value=\"Jingle Bells\" />\n" +
                "<property name=\"instrument\">\n" +
                "<bean class=\"org.springinaction.springidol.Saxophone\" />\n" +
                "</property>\n" +
                "</bean>");
    }
}
