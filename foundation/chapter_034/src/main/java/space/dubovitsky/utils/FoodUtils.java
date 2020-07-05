package space.dubovitsky.utils;

import org.springframework.stereotype.Component;
import space.dubovitsky.entity.Food;

import java.util.Date;

@Component
public class FoodUtils {

    public static Food generateFood() {
        String[] names = {"Head Cheese", "Цыпленок табака", "Рулетики из сельд", "Hot Dog", "Мавр в рубашке"};
        String[] producer = {"GREW Corp", "MASE Corp", "ULTIMA"};
        Food food = new Food(
                names[randomNumberGenerator(names.length)],
                producer[randomNumberGenerator(producer.length)],
                new Date());
        return food;
    }

    private static int randomNumberGenerator(int max) {
        int a = (int) ( Math.random() * max );
        return a;
    }

}
