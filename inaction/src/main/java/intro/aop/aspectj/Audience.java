package intro.aop.aspectj;

import org.aspectj.lang.annotation.*;

@Aspect
public class Audience {

    // TODO Не знаю что тут делать?!
    @Pointcut("execution(* *aop.aspectj.Performer.doAction(..))")
    public void perform() {

    }

    @Before("perform()")
    public void takeSeats() {
        System.out.println("People! Please! Seat down!");
    }
}
