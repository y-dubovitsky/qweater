package ioc.config_with_xml.config;

import ioc.config_with_xml.OutputMessage;
import ioc.config_with_xml.OutputMessageImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

@ImportResource(locations = {"ioc/configwithxml/app-context-xml.xml"})

@org.springframework.context.annotation.Configuration
public class Config {

    /**
     * This bean use UserMessage userMessage; from .xml config
     * @return
     */
    @Bean
    public OutputMessage outMessage() {
        return new OutputMessageImpl();
    }

}
