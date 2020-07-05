package space.dubovitsky.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class Logger {
    public Object timeCalculate(ProceedingJoinPoint joinPoint) {
        Object object = null;
        long start = System.currentTimeMillis();
        System.out.println("Aspect begin : " + joinPoint.getSignature());
        try {
            object = joinPoint.proceed(); //! Должен быть явно вызван, так как грубо говоря этот метод public Object timeCalculate(..) теперь как бы оболочка над вызываемым методом -> основной метод должен быть явно вызван
        } catch (Throwable t) {
            t.getMessage();
        }
        long timeProcess = System.currentTimeMillis() - start;
        System.out.println("Aspect end with time : " + timeProcess + " ms");
        return object;
    }
}
