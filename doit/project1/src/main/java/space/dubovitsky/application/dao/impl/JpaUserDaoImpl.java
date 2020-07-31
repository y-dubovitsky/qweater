package space.dubovitsky.application.dao.impl;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import space.dubovitsky.application.dao.UserDao;
import space.dubovitsky.application.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
@Transactional(readOnly = true)
public class JpaUserDaoImpl implements UserDao {

    @PersistenceContext(unitName = "entityManagerFactory") //?
    private EntityManager entityManager;

    @Override
    public List<User> findAllUser() {
        List<User> userList = entityManager
                .createQuery("select u from User u", User.class)
                .getResultList();
        return userList;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User findUserByEmail(String email) {
        TypedQuery<User> query = entityManager.createQuery("select u from User u where email = :email", User.class);
        query.setParameter("email", email);
        User singleResult = query.getSingleResult();
        return singleResult != null ? singleResult : null; //? Можно так и не делать
    }
}
