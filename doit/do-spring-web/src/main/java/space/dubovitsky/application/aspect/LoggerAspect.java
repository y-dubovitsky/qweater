package space.dubovitsky.application.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

    @Before(value = "execution(* space.dubovitsky.application.service.*.*(..))")
    public void beforeAllMethodInvocation(JoinPoint joinPoint) {
        System.out.println("Invocation: " + joinPoint.getSignature());
    }

    @Around("execution(* space.dubovitsky.application.service.impl.UserServiceImpl.findAllUser())")
    public Object aroundMethodServiceInvocation(ProceedingJoinPoint joinPoint) throws Throwable {
        long before = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long after = System.currentTimeMillis();
        System.out.println("Execution time: " + (before - after));
        return proceed;
    }

}
