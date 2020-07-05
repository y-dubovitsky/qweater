package space.dubovitsky.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;
import space.dubovitsky.service.NumberService;

@Component
public class WrapperNumberService {

    //private Integer[] arg = {0};

    /**
     * Данный метод служит "оберткой" над методом сервисом в классе public class NumberService {}
     * @param joinPoint
     * @return
     */
    public Object wrapNumberService(ProceedingJoinPoint joinPoint) {
        Object object = null;
        System.out.println("Before");
        try {
            object = joinPoint.proceed(); //! object - результат выполнения метода
            if (object instanceof NumberService) {
                System.out.println("NumberService");
            }
            if (object instanceof Integer) {
                Integer integer = (Integer) object;
                System.out.println("Integer : " + integer);
            }
        } catch (Throwable t) {
            t.getMessage();
        }
        System.out.println("After");
        return object;
    }

}
