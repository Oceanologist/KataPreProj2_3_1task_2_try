package web.dao;



import org.springframework.stereotype.Repository;
import web.model.User;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void add(User user) {
        manager.persist(user);
    }

    @Override
    public void delete(User user) {
        manager.remove(user);
    }


    public void edit(User user, int userId) {
        User existingUser = manager.find(User.class, userId);
        if (existingUser == null) {
            throw new IllegalArgumentException("User not found");
        }
        existingUser.setName(user.getName());
        existingUser.setSurname(user.getSurname());
        existingUser.setAge(user.getAge());
    }

    @Override
    public List<User> viewAllUsers() {
        String jpql = "SELECT u FROM User u";
        TypedQuery<User> query = manager.createQuery(jpql, User.class);
        return query.getResultList();
    }
}