package space.dubovitsky.application.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class DataController {

    private static final Random random = new Random();

    @GetMapping("/api/data-list")
    @ResponseBody
    public List<String> getDataList() {
        return Stream.generate(() -> String.valueOf(random.nextInt()))
        .limit(10)
        .collect(Collectors.toList());
    }

}
