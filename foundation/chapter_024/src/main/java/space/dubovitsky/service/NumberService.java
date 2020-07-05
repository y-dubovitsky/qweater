package space.dubovitsky.service;

import org.springframework.stereotype.Component;

@Component
public class NumberService {

    public int getInt() {
        return 1;
    }

    public double getDouble() {
        return 1.1;
    }

    public float divideNumbers(int a, int b) {
        return a/b;
    }

}
