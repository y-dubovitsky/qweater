package ioc.method_replace;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

public class ClassMethodReplacer implements MethodReplacer {

    /**
     * This method replace input method
     */
    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        if (isFormatMessageMethod(method)) {
            String msg = (String) args[0];
            return "<h3>" + msg + "</h3>";
        } else {
            throw new IllegalArgumentException(
                    "We cant replace method " + method.getName()
            );
        }
    }

    private boolean isFormatMessageMethod(Method method) {
        if (method.getParameterTypes().length != 1) {
            return false;
        }
        // various checking
        return true;
    }
}
