package aop.music;

import org.aspectj.lang.ProceedingJoinPoint;

public class Prepare {

    public void checkInstrum() {
        System.out.println("Checking instrument");
    }

    public void putCase() {
        System.out.println("Put in the case");
    }

    public void watchPerformance(ProceedingJoinPoint joinPoint) {

        try {
            long start = System.currentTimeMillis();

            joinPoint.proceed();
            Thread.sleep(1000);
            long end = System.currentTimeMillis();

            System.out.println("The perform took " + (end - start) + " millis");
        } catch (Throwable e) {
            e.printStackTrace();
        }

    }
}
