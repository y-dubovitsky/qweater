package intro.bind.annotation.withoutxml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Runner implements Sportsman {

    @Autowired
    @Qualifier("run")
    private Perform perform;

    @Override
    public void forwardToWinn() {
        perform.doAction();
    }
}
