package space.dubovitsky.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import space.dubovitsky.impls.MathService;

@Component
@Aspect
public class MathAspect {

    /**
     * Применяется ко всем классам, реализующим данный интерфейс
     */
    @Pointcut(value = "execution(* space.dubovitsky.interfaces.Calculable.*(int))")
    private void first(){};

    @Pointcut(value = "execution(public int space.dubovitsky.interfaces.Calculable.*(int, int))")
    private void second(){};

    @Around(value = "first()")
    public Object aroundGetListNumbers(ProceedingJoinPoint joinPoint) {
        System.out.println("@Around start " + joinPoint.getSignature());
        Object[] args = joinPoint.getArgs(); //! Получаем массив аргументов, переданных в метод
        for (Object o : args) {
            System.out.println(o);
        }
        long start = System.currentTimeMillis(); //* Засекаем время
        Object object = null;
        try {
            object = joinPoint.proceed(); //! Объектом служит результат работы метода
        } catch (Throwable t) {
            t.getMessage();
        }
        System.out.println("Time proceed : " + (start - System.currentTimeMillis()));
        System.out.println(object);
        System.out.println("@Around end");
        return object; //! Возвращаем результат работы метода
    }

    @Before(value = "second() && target(target)", argNames = "joinPoint, target") //? target(target) что это
    public void before(JoinPoint joinPoint, Object target) {
        System.out.println("@Before start : " + joinPoint.getSignature());
        if (target instanceof MathService) {
            MathService mathService = (MathService) target;
            mathService.getSum(5,5);
        }
    }

    @AfterReturning(value = "second()", returning = "sum")
    public void afterReturning(JoinPoint joinPoint, int sum) {
        System.out.println("@AfterReturning : " + joinPoint.getSignature());
        System.out.println("Sin : " + Math.sin(sum));
    }

    /**
     * args(a, b) - именя аргуметов из метода public int[] getIntArray(int a, int b) {}
     */
    @AfterReturning(value = "execution(public int[] space.dubovitsky.impls.MathService.getInt*(int, int)) && args(a, b)", returning = "object") //! returning = "object" и public Object afterReturningGetIntArray(Object object - это входные данные для совета и выходные для метода, которые этот совет обрабатывает
    public Object afterReturningGetIntArray(JoinPoint joinPoint, Object object, int a, int b) { //!  Порядок следования аргументов ИМЕЕТ ЗНАЧЕНИЕ: 1 - JoinPoint joinPoint
        System.out.println("@AfterReturning " + joinPoint.getSignature());
        System.out.println(object.getClass().getCanonicalName() + " method result: " + object);
        return object;
    }

    @Before(value = "execution(public double space.dubovitsky.impls.MathService.getDoubleValue(double)) && args(value))") //! Этот метод никак не влияет на ход выполнения метода после, того как данный совет отработает
    public void beforeGetDoubleValue(JoinPoint joinPoint, double value) {
        System.out.println("@beforeGetConstant : " + joinPoint.getSignature());
        System.out.println(++value);
    }
}
