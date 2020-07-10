package begin.spring.annotation;

import begin.hello.MessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class ConfigurableMessageProvider implements MessageProvider {

    private String message;

    @Autowired
    public ConfigurableMessageProvider(@Value("Configurable Message") String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
