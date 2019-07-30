package intro.bind.annotation.withoutxml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Jumper implements Sportsman {

    @Autowired
    @Qualifier("jump")
    private Perform perform;

    @Override
    public void forwardToWinn() {
        perform.doAction();
    }
}
