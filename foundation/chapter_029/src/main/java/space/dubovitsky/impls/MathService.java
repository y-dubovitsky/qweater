package space.dubovitsky.impls;

import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import space.dubovitsky.interfaces.Calculable;

import java.util.ArrayList;
import java.util.List;

@Component
public class MathService implements Calculable {

    private final int MATH_SERVICE_CONSTANT = 100;

    @Override
    public List<Integer> getListNumbers(int a) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            list.add(i);
        }
        return list;
    }

    @Override
    public int getSum(int a, int b) {
        return a + b;
    }

    @Override
    public void printArrayNumbers(int limit) {
        for (int i = 0; i < limit; i++) {
            System.out.println(i);
        }
    }

    @Override
    public void getConstant() {
        System.out.println(MATH_SERVICE_CONSTANT);
    }

    @Override
    public int[] getIntArray(int a, int b) {
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = a + b + i;
        }
        return array;
    }

    @Override
    public double getDoubleValue(double value) {
        return value;
    }
}
