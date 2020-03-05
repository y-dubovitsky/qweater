package intro.di.math;

public class MathAction {

    private int value;
    private double pi;


    public MathAction() {
    }

    public void sout() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Value = " + this.value + " Pi = " + this.pi);
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public double getPi() {
        return pi;
    }

    public void setPi(double pi) {
        this.pi = pi;
    }
}
