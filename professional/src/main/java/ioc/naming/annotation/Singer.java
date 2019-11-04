package ioc.naming.annotation;

import org.springframework.stereotype.Component;

@Component
public class Singer {

    private String lyrics = "Tra la la la";

    public void sing() {
        System.out.println(lyrics);
    }

}
