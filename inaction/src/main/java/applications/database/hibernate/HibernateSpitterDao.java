package applications.database.hibernate;

import applications.database.jdbc.Spitter;
import applications.database.jdbc.SpitterDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import javax.transaction.TransactionManager;

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
    private HibernateTransactionManager transactionManager;

    private TransactionTemplate txTemplate = new TransactionTemplate(transactionManager);

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

    /**
     * This method uses transaction;
     * Чтобы иметь возможность использовать класс TransactionTemplate,
     * необходимо сначала реализовать интерфейс TransactionCallback. Так
     * как интерфейс TransactionCallback определяет единственный метод,
     * часто бывает проще реализовать его в виде анонимного вложенного класса
     * @param spitter
     */
    public void saveSpitter(Spitter spitter) {
        txTemplate.execute(new TransactionCallback() {
            @Override
            public Object doInTransaction(TransactionStatus transactionStatus) {
                try {
                    addSpitter(spitter);
                } catch (RuntimeException e) {
                    transactionStatus.setRollbackOnly();
                    throw e;
                }
                return null;
            }
        });
    }
}
