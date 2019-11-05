package ioc.dependencies;

/**
 * Simple class with one method!
 */
public class Sex {

    private String male;

    public Sex(String male) {
        this.male = male;
    }

    public void doAction() {
        System.out.println("What is is?");
    }

}
