package ioc.visible;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("Rampage")
public class Player {

    private String game = "Ultima Online";

    public Player(@Value("Call of Duty") String string) {
        this.game = string;
    }

    @Override
    public String toString() {
        return super.toString() + " " + game;
    }
}
