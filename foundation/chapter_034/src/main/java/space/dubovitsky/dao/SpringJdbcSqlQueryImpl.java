package space.dubovitsky.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import space.dubovitsky.entity.Food;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SpringJdbcSqlQueryImpl implements SqlQuery<Food> {

    private NamedParameterJdbcTemplate template;

    private RowMapper<Food> FOOD_ROW_MAPPER = ResultSetFactory.FOOD_ROW_MAPPER;
    private ResultSetExtractor<Food> FOOD_RESULT_SET_EXTRACTOR = ResultSetFactory.FOOD_RESULT_SET_EXTRACTOR;
    private ResultSetExtractor<Map<String, String>> MAP_RESULT_SET_EXTRACTOR = ResultSetFactory.MAP_RESULT_SET_EXTRACTOR;

    @Autowired
    public SpringJdbcSqlQueryImpl(DataSource dataSource) { //? Можно ли так объявлять DataSource и NamedParameterJdbcTemplate
        this.template = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public void insert(Food food) { //TODO Сделать так чтобы метод возвращал id вставленной записи KeyHolder...
        String sql = "insert into food(name, producer, date_expired) values(:name, :producer, :date_expired)";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("name", food.getName());
        parameterSource.addValue("producer", food.getProducer());
        parameterSource.addValue("date_expired", food.getDate());

        template.update(sql, parameterSource);
    }

    @Override
    public Food getById(int id) {
        String sql = "select * from food where id = :id";
        Map<String, Integer> map = new HashMap<>();
        map.put("id", id);
        MapSqlParameterSource param = new MapSqlParameterSource(map); //! В конструктор можно карту передавать

        Food food = template.queryForObject(sql, param, new RowMapper<Food>() { //! Анонимный класс передется
            @Override
            public Food mapRow(ResultSet resultSet, int i) throws SQLException {
                return new Food(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("producer"),
                        resultSet.getDate("date_expired")
                );
            }
        });
        return food;
    }

    @Override
    public Food getByName(String name) { //TODO Дописать
        return null;
    }

    @Override
    public List<Food> getListByName(String name) {
        String sql = "select * from food where name like :name";
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("name", "%" + name + "%"); //! % - любые символы в любом количестве

        List<Food> foodList = template.query(sql, param, FOOD_ROW_MAPPER); //! foodRowMapper - объект класса RowMapper<Food>
        return foodList;
    }

    @Override
    public Map<String, String> getStats() {
        String sql = "select name, count(*) as count from food group by name"; //! as count - обязательно, чтобы создалась виртуальная колонка
        Map<String, String> map = template.query(sql, MAP_RESULT_SET_EXTRACTOR);
        return map;
    }
}
