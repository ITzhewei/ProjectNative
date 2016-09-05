package service;

import domain.User;

/**
 * Created by john on 2016/9/5.
 */
public interface UserService {

    /**
     * 注册
     *
     * @param user
     * @throws Exception
     */
    public void register(User user) throws Exception;

    /**
     * 登录
     *
     * @param user
     * @return
     * @throws Exception
     */
    public User login(User user) throws Exception;

}
