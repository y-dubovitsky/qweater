package space.dubovitsky.jwtapp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Класс для логирования
 */
@Aspect
@Component
public class LoggerAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(public * space.dubovitsky.jwtapp.service.impl.UserServiceImpl.*(..))")
    public void callAtUserServiceImpl() { }

    @Pointcut("execution(public org.springframework.security.core.userdetails.UserDetails space.dubovitsky.jwtapp.security.JwtUserDetailsService.loadUserByUsername(String) )")
    public void callSecurityMethodLoadUserByUsername() {}

    @Before("callAtUserServiceImpl()")
    public void beforeCallAtMethod1(JoinPoint jp) {
        String args = getArgs(jp);
        logger.info("before method " + jp.getSignature().getName() + jp.toString() + ", args=[" + args + "]");
    }

    @AfterReturning(pointcut="callSecurityMethodLoadUserByUsername()", returning="userDetails")
    public void afterReturningLoadUserByUsername(UserDetails userDetails) {
        logger.info(String.format("User with username: %s successfully loaded", userDetails.getUsername()));
    }

    private String getArgs(JoinPoint jp) {
        return Arrays.stream(jp.getArgs())
                    .map(Object::toString)
                    .collect(Collectors.joining(","));
    }
}
