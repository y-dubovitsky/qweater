package shrt.bind.xml;

public class Vasya implements Alcoholic {

    private Drink drink;

    public Vasya() {
    }

    public Vasya(Drink drink) {
        this.drink = drink;
    }

    @Override
    public void drinkUp() {

    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }
}
