package space.dubovitsky.doit.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface AutoInsert { //! Собственная аннотаций, которая позволяет через рефлексию в фабрике сетать поля
}
