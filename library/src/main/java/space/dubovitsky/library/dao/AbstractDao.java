package space.dubovitsky.library.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * Общий интерфейс для всех ДАО классов
 * @param <T>
 */
public interface AbstractDao<T> {

    T get(long id);

    T save(T p);

    void delete(T p);

    List<T> getAll();

    List<T> search(String... searchString);

    List<T> getAll(Sort sort);

    Page<T> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection);

    Page<T> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String... searchString);

}
