package space.dubovitsky.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import space.dubovitsky.entity.Food;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


public class ResultSetFactory  {

    public static final RowMapper<Food> FOOD_ROW_MAPPER = new RowMapper<Food>() {
        @Override
        public Food mapRow(ResultSet resultSet, int i) throws SQLException { //? Что за параметр int i?
            return new Food(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("producer"),
                    resultSet.getDate("date_expired")
            );
        }
    };

    public static final ResultSetExtractor<Food> FOOD_RESULT_SET_EXTRACTOR = new ResultSetExtractor<Food>() {
        @Override
        public Food extractData(ResultSet resultSet) throws SQLException, DataAccessException {
            return new Food(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("producer"),
                    resultSet.getDate("date_expired")
            );
        }
    };

    public static final ResultSetExtractor<Map<String, String>> MAP_RESULT_SET_EXTRACTOR = new ResultSetExtractor<Map<String, String>>() {
        @Override
        public Map<String, String> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
            Map<String, String> map = new HashMap<>();
            while (resultSet.next()) { //! Мы проходим по ResultSet, так как у нас множество данных а не 1 строка
                String name = resultSet.getString("name");
                String count = resultSet.getString("count");
                map.put(name, count);
            }
            return map;
        }
    };
}
