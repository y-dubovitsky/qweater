package ioc.singer;

import org.springframework.stereotype.Component;

@Component("inspiration")
public class InspirationBean implements Inspiration {

    @Override
    public String getLyrics() {
        return "unnecessary: варианты перевода\n" +
                "Имя ПрилагательноеЧастота\n" +
                "ненужный\n" +
                "unnecessary, unwanted, waste, needless, superfluous, supervacaneous\n" +
                "лишний\n" +
                "excess, extra, redundant, unnecessary, spare, odd\n" +
                "излишний\n" +
                "surplus, excessive, superfluous, unnecessary, redundant, needless";
    }
}
