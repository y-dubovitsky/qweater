package di.idol.instruments;

public class Guitar implements Instrument {

    String[] accords = {"Звукоряд в наше время выглядит так: ",
            "C (До), D (Ре), E (Ми), F (Фа), G (Соль), ",
            "A (Ля), H (Си). Но в старину вместо ноты Си использовалась " +
            "Си-бемоль и обозначалась она буквой \"B\". А самой низкой из ",
            "употреблявшихся нот была A (Ля). Звукоряд выглядел так: ",
            "А (Ля), В (Си-бемоль), С (До), D (Ре), Е (Ми), F (Фа), G (Соль)."};

    @Override
    public void play() {
        for (String s : accords) {
            System.out.println(s);
        }
    }
}
