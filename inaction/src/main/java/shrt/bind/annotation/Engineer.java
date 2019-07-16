package shrt.bind.annotation;

import org.springframework.beans.factory.annotation.Autowired;

public class Engineer implements Worker{

    public Engineer(){

    }

    @Autowired
    private Function function;

    @Override
    public void doWork() {
        function.doFunction();
    }
}
