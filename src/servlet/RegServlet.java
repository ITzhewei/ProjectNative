package servlet;

import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by john on 2016/9/5.
 */
@WebServlet("/regServlet")
public class RegServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("utf-8");
        //得到应用目录
        String contextPath = req.getContextPath();
        //得到向客户端输出的字符流
        PrintWriter out = resp.getWriter();
        /**以上是头部**/


        //获取表单数据
        User user = new User();
        try {
            BeanUtils.populate(user, req.getParameterMap()); //封装数据
        } catch (Exception e) {
            e.printStackTrace();
        }
        //调用业务员逻辑
        UserService userService = new UserServiceImpl();
        try {
            userService.register(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //分发转向
        out.print("注册成功!一秒后跳转到主页");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
