package space.dubovitsky.application.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import space.dubovitsky.application.dao.UserDao;
import space.dubovitsky.application.entity.User;

import java.util.List;

@Component
public class HibernateUserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> findAllUser() {
        List<User> userList = getCurrentSession().createQuery("from User", User.class).getResultList();
        return userList;
    }

    @Override
    public void addUser(User user) {
        getCurrentSession().save(user);
    }

    @Override
    public User findUserByEmail(String email) {
        Query<User> query = getCurrentSession().createQuery("from User where email = :email", User.class);
        query.setParameter("email", email);
        return query.stream().findAny().orElse(null);
    }

//    utility private methods
    private Session getCurrentSession() {
        return sessionFactory.openSession();
    }
}
