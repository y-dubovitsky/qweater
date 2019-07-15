package begin.spring.annotation;

import begin.HelloWorldMessageProvider;
import begin.MessageProvider;
import begin.MessageRender;
import begin.StandardOutMessageRender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfiguration {
    @Bean
    public MessageProvider provider() {
        return new HelloWorldMessageProvider();
    }

    @Bean
    public MessageRender render() {
        MessageRender messageRender = new StandardOutMessageRender();
        messageRender.setMessageProvider(provider());
        return messageRender;
    }
}
