package space.dubovitsky.application.utils;

import space.dubovitsky.application.entity.User;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserUtils {

    private static final Random random = new Random();

    public static List<User> generateUserList() {
        return Stream
                .generate(() -> new User(
                        "Smith",
                        random.nextInt(),
                        random.nextInt() + "@mail.ru",
                        "password" + random.nextInt(),
                        true))
                .limit(10)
                .collect(Collectors.toList());
    }

}
