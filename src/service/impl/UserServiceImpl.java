package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.User;
import service.UserService;

/**
 * Created by john on 2016/9/5.
 */
public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public void register(User user) throws Exception {
        userDao.addUser(user);
    }

    @Override
    public User login(User user) throws Exception {
        User u = userDao.findUser(user);
        return u;
    }
}
