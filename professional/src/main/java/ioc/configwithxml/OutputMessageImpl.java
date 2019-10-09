package ioc.configwithxml;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * This class get UserMessage by @Autowired (used .xml config)
 */
public class OutputMessageImpl implements OutputMessage {

    UserMessage userMessage;

    /**
     * Attention!
     * @param userMessage
     */
    @Autowired
    public void setUserMessage(UserMessage userMessage) {
        this.userMessage = userMessage;
    }

    /**
     * Output on the console some string from user(UpperCase)
     */
    @Override
    public void outMessage() {
        System.out.println(userMessage.getMessage().toUpperCase());
    }
}
