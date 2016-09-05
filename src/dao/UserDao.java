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
    public void addUser(User user) throws Exception;

}
