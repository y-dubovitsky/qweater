package intro.bind.annotation.withxml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Engineer implements Worker{

    public Engineer(){

    }

    @Autowired
    @Qualifier("program")
    private Function function;

    @Override
    public void doWork() {
        function.doFunction();
    }
}
