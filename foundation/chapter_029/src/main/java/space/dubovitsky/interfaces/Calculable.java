package space.dubovitsky.interfaces;

import java.util.List;

public interface Calculable {

    List<Integer> getListNumbers(int i);

    int[] getIntArray(int a, int b);

    int getSum(int a, int b);

    void printArrayNumbers(int limit);

    void getConstant();

    double getDoubleValue(double v);
}
