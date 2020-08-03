package space.dubovitsky.application.config;

import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

//! Этот класс нужен для того, чтобы спринг поднимал секьюрность
@Order(2)
public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {
}
