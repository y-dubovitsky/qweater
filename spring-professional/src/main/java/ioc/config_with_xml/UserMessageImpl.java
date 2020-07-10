package ioc.config_with_xml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Implementation
 */
public class UserMessageImpl implements UserMessage{

    /**
     * Getting string from console;
     */
    @Override
    public String getMessage() {
        String str = null;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            str = reader.readLine();
        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            return str;
        }
    }
}
