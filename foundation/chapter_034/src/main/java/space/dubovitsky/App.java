package space.dubovitsky;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import space.dubovitsky.dao.SpringJdbcSqlQueryImpl;
import space.dubovitsky.entity.Food;
import space.dubovitsky.utils.FoodUtils;

import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("FoodAppContext.xml");
        SpringJdbcSqlQueryImpl springJdbcSqlQueryImpl = (SpringJdbcSqlQueryImpl) context.getBean("springJdbcSqlQueryImpl");
        //* insert
        springJdbcSqlQueryImpl.insert(FoodUtils.generateFood());
        //* get by id
        Food byId = springJdbcSqlQueryImpl.getById(2);
        System.out.println(byId);
        //* public List<Food> getListByName
        List<Food> head = springJdbcSqlQueryImpl.getListByName("Head");
        for (Food f : head) {
            System.out.println(f);
        }
        //* public Map<String, String> getStats()
        Map<String, String> stats = springJdbcSqlQueryImpl.getStats();
        for (String key : stats.keySet()) {
            System.out.println("Key : " + key + " Value: " + stats.get(key));
        }
    }
}
