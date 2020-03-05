package intro.aop.aspectj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Actor implements Performer{

    @Autowired
    @Qualifier("poem")
    Performance performance;

    public void doAction() {
        performance.perform();
    }
}
