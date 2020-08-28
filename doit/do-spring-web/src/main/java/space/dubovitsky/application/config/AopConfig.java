package space.dubovitsky.application.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//! Хотя этот класс можно и не создавать
@Configuration
@EnableAspectJAutoProxy //! Создает прокси объекты, к тем классам к которым применяются "эдвайся"
public class AopConfig {
}
