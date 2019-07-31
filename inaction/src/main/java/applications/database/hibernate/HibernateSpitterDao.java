package applications.database.hibernate;

import applications.database.jdbc.Spitter;
import applications.database.jdbc.SpitterDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Implementation of SpitterDao interface. Uses hibernate!
 */
@Repository
public class HibernateSpitterDao implements SpitterDao {

    /**
     * Uses Session factory for getting Session;
     * Основным интерфейсом для взаимодействий с Hibernate является интерфейс org.hibernate.Session. Интерфейс Session обеспечивает
     * базовую функциональность доступа к данным, позволяя сохранять,
     * обновлять, удалять и загружать объекты в/из базы данных. Именно
     * через интерфейс Session прикладные объекты DAO будут выполнять
     * все операции с хранилищем данных.
     */
    private SessionFactory sessionFactory;

    @Autowired
    public HibernateSpitterDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Getting session
     */
    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addSpitter(Spitter spitter) {
        currentSession().save(spitter);
    }

    @Override
    public Spitter getSpitterById(long id) {
        return (Spitter) currentSession().get(Spitter.class, id);
    }
}
