package dao.impl;

import dao.UserDao;
import domain.User;
import utils.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

/**
 * Created by john on 2016/9/5.
 */
public class UserDaoImpl implements UserDao {

    @Override
    public void addUser(User user) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DbUtils.getConnection();
            ps = conn.prepareStatement("INSERT  INTO users(username,PASSWORD,email,birthday)VALUES (?,?,?,?);");
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String birthday = sdf.format(user.getBirthday());
            ps.setString(4, birthday);
            boolean execute = ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("添加失败");
        } finally {
            DbUtils.closeAll(null, ps, conn);
        }
    }

}
