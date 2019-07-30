package applications.database.jdbc;

/**
 * Тут должны быть методы работы с Базой данных.
 */
public interface SpitterDao {

    void addSpitter(Spitter spitter);

    Spitter getSpitterById(long id);
}
