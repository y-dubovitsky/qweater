package space.dubovitsky.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Aspect
public class Logger {

    @Pointcut("execution(* space.dubovitsky..*(..)))")
    private void pointCutId(){}

    @Pointcut("execution(* *(..)) && within(space.dubovitsky.service.*)")
    private void pointCutWithIn(){}

    @Pointcut("execution(* *(String)) && @annotation(space.dubovitsky.annotation.NotReturnResult)")
    private void userAnnotated(){}

    @Before(value = "pointCutId()")
    public void before() {
        System.out.println("@Before");
    }

    @Around("pointCutId()")
    public Object timeCalculate(ProceedingJoinPoint joinPoint) {
        System.out.println("@Around");
        Object object = null;
        long start = System.currentTimeMillis();
        try {
            object = joinPoint.proceed();
        } catch (Throwable t) {
            t.getMessage();
        }
        long timeExecution = start - System.currentTimeMillis();
        System.out.println("Время выполнения метода : " + timeExecution + " Millis");
        return object;
    }

    @AfterReturning(pointcut = "execution(* space.dubovitsky.service.FileService.fileInfo(String))", returning = "object") //! returning = "object" - это возвращаемое значение из метода к которому применяется совет, а совет теперь его обрабатывает (совет - printInfo)
    public void printInfo(Object object) {
        System.out.println("@AfterReturning");
        if (object instanceof Map) {
            Map<String, String> map = (Map<String, String>) object;
            for (String key : map.keySet()) {
                System.out.println(key + " " + map.get(key));
            }
        }
    }

    @After(value = "userAnnotated()")
    public void after() {
        System.out.println("@After");
    }
}
