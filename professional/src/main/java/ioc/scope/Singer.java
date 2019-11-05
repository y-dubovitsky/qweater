package ioc.scope;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("notSingleton")
@Scope("prototype")
public class Singer {

    private String name = "unknown";

    public Singer(@Value("Roy Jones") String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
