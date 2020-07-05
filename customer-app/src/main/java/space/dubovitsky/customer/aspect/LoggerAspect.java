package space.dubovitsky.customer.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
@Component
public class LoggerAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(public * space.dubovitsky.customer.service.impl.CustomerServiceImpl.*(..))")
    public void callAtCustomerServiceImpl() { }

    @Before("callAtCustomerServiceImpl()")
    public void beforeCallAllMethods(JoinPoint jp) {
        String args = getArgs(jp);
        logger.info("before " + jp.toString() + ", args=[" + args + "]");
    }

    private String getArgs(JoinPoint jp) {
        return Arrays.stream(jp.getArgs())
                    .map(a -> a.toString())
                    .collect(Collectors.joining(","));
    }
}

