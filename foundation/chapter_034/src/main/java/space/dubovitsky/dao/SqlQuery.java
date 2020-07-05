package space.dubovitsky.dao;

import java.util.List;
import java.util.Map;

public interface SqlQuery<T> {

    void insert(T t);

    T getById(int id);

    T getByName(String name);

    List<T> getListByName(String name);

    Map<String, String> getStats();

}
