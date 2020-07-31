package space.dubovitsky.application.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class LoggerAspect {

    public void beforeAllMethodInvocation(JoinPoint joinPoint) {
        System.out.println("Invocation: " + joinPoint.getSignature());
    }

    public Object aroundMethodServiceInvocation(ProceedingJoinPoint joinPoint) throws Throwable {
        long before = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long after = System.currentTimeMillis();
        System.out.println("Execution time: " + (before - after));
        return proceed;
    }

}
