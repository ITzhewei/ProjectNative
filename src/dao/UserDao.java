package dao;

import domain.User;

/**
 * Created by john on 2016/9/5.
 */
public interface UserDao {
    /**
     * 添加用户信息
     *
     * @param user
     * @throws Exception
     */
    void addUser(User user) throws Exception;

    /**
     * 根据用户名和密码查找
     * @param user
     * @return
     * @throws Exception
     */
    User findUser(User user) throws Exception;
}
