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
    public void delete(int id) {
        userDAO.delete(id);
    }

    @Override
    public void update(User user, int id) {
        userDAO.update(user,id);

    }


    @Override
    public User findById(int id) {
        return userDAO.findUserById(id);

    }

    @Transactional
    @Override
    public List<User> viewAllUsers() {
        System.out.println("viewAllUsers method working");
        List<User> userList = userDAO.viewAllUsers();
        for (User user : userList) {
            user.toString();
        }

        return userList;
    }


}