package space.dubovitsky.ioc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import space.dubovitsky.ioc.component.MessageProvider;
import space.dubovitsky.ioc.component.MessageRender;
import space.dubovitsky.ioc.component.impl.MessageProviderImpl;
import space.dubovitsky.ioc.component.impl.MessageRenderImpl;

@Configuration
public class BeanConfig {

    @Bean
    public MessageProvider messageProvider() {
        return new MessageProviderImpl();
    }

    @Bean
    public MessageRender messageRender(@Autowired MessageProvider messageProvider) {
        return new MessageRenderImpl(messageProvider);
    }

}
