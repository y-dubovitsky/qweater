package shrt.bind.annotation.withxml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class StrictTeacher implements Worker {

    @Autowired
    @Qualifier("lesson")
    private Function function;

    public StrictTeacher() {
    }

    public StrictTeacher(Function function) {
        this.function = function;
    }

    @Override
    public void doWork() {

    }
}
