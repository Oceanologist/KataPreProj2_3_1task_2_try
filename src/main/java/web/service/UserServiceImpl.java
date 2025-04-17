package web.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDAO;
import web.model.User;


import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserDAO userDAO;


    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    @Override
    public void add(User user) {
        userDAO.add(user);
    }

    @Transactional
    @Override
    public void delete(User user) {
        userDAO.delete(user);
    }

    @Transactional
    @Override
    public void edit(User user, int userId) {
        userDAO.edit(user, userId);
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Transactional
    @Override
    public List<User> viewAllUsers() {
        return userDAO.viewAllUsers();
    }


}