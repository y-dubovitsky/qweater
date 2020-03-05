package intro.aop.music;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Audience {
    @Pointcut(
            "execution(* *.play(..))")
    public void play() {

    }

    @Before("play()")
    public void takeSeats() {
        System.out.println("Please seat down");
    }

}
