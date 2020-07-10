package ioc.dependencies;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("chair")
public class Chair {

    private String chair;

    public Chair(@Value("armchair") String str) {
        this.chair = str;
    }

    public void moveChair() {
        System.out.println("We move this " + chair);
    }

}
