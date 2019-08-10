package begin.spring.annotation;

import begin.hello.HelloWorldMessageProvider;
import begin.hello.MessageProvider;
import begin.hello.MessageRender;
import begin.hello.StandardOutMessageRender;
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
