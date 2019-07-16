package shrt.bind.annotation;

public class Diagnosis implements Function {

    @Override
    public void doFunction() {
        System.out.println("You are very ill! Give me 500$");
    }
}
