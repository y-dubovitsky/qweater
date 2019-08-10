package ioc;

public class BookwormOracle implements Oracle {

    private Encyclopedia encyclopedia;

    public void setEncyclopedia(Encyclopedia en) {
        this.encyclopedia = en;
    }

    @Override
    public String defineMeaningOfLif() {
        return "Wasted time";
    }
}
