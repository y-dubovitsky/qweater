package intro.bind.xml;

/**
 * This class havent constructor, but java create him
 */
public class MrsSmith implements Alcoholic {

    Drink drink;

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
