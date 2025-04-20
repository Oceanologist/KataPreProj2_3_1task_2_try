package web.dao;


import org.springframework.stereotype.Repository;
import web.model.User;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void add(User user) {
        manager.persist(user);
    }


    @Override
    public void update(User user, int id) {
        User newUser = manager.find(User.class, id);
        newUser.setName(user.getName());
        newUser.setSurname(user.getSurname());
        newUser.setAge(user.getAge());
    }

    @Override
    public List<User> viewAllUsers() {
        String jpql = "SELECT u FROM User u";
        TypedQuery<User> query = manager.createQuery(jpql, User.class);
        return query.getResultList();
    }

    @Override
    public User findUserById(int id) {
        return manager.find(User.class, id);

    }

    @Override
    public void delete(int id) {
        manager.remove(findUserById(id));
    }
}