package shrt.bind.xml;

public class Man implements Alcoholic {

    private Drink drink;

    public Man() {
    }

    @Override
    public void drinkUp() {
        drink.doAction();
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }
}
