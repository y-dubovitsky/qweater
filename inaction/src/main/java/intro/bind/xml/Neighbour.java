package intro.bind.xml;

/**
 * Class with constructor;
 */
public class Neighbour implements Alcoholic{

    private Drink drink;

    public Neighbour(Drink drink) {
        this.drink = drink;
    }

    public Neighbour() {
    }

    @Override
    public void drinkUp() {
        drink.doAction();
    }
}
