package shrt.bind.annotation;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * In this class @annotated set method by spring @Annotation!
 */
public class Doctor implements Worker {

    private Function function;

    public Doctor() {

    }

    @Override
    public void doWork() {
        function.doFunction();
    }

    public Function getFunction() {
        return function;
    }

    /**
     * Look at this!
     * @param function
     */
    @Autowired
    public void setFunction(Function function) {
        this.function = function;
    }
}
