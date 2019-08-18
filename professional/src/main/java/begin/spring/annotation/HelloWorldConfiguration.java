package begin.spring.annotation;

import begin.hello.HelloWorldMessageProvider;
import begin.hello.MessageProvider;
import begin.hello.MessageRender;
import begin.hello.StandardOutMessageRender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// This just like context: component-scan in .xml configuration file
@ComponentScan(basePackages = {"begin.spring.annotation"})

/**
 * Configuration class
 */
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
