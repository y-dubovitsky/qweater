package intro.bind.annotation.withoutxml;

public class Jump implements Perform {

    @Override
    public void doAction() {
        System.out.println("Jump! Jump! Jump! And more Jump!");
    }
}
