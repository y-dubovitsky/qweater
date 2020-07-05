package form.handler;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.SessionTrackingMode;
import java.util.EnumSet;

public class StartApplication implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        setServletContextSettings(servletContext);
        AnnotationConfigWebApplicationContext springContext = createSpringContext(servletContext);
        createDispatcherServlet(servletContext, springContext);
    }

    private AnnotationConfigWebApplicationContext createSpringContext(ServletContext servletContext) {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext(); //* Конфигурируем контейнер на основе аннотаций
        ctx.scan("form.handler");
        ctx.setServletContext(servletContext); //? Добавляем в контейнер Спринг серлвет контекст
        ctx.refresh();

        return ctx;
    }

    private void createDispatcherServlet(ServletContext servletContext, AnnotationConfigWebApplicationContext ctx) {
        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
    }

    private void setServletContextSettings(ServletContext servletContext) {
        servletContext.setSessionTrackingModes(EnumSet.of(SessionTrackingMode.COOKIE));
    }
}
