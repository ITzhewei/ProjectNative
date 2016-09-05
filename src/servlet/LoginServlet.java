package servlet;

import domain.User;
import org.apache.commons.beanutils.BeanUtils;
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
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
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

        //获得表单数据
        User user = new User();
        try {
            BeanUtils.populate(user, req.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //处理业务逻辑
        UserServiceImpl userService = new UserServiceImpl();
        try {
            user = userService.login(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //转发
        if (user != null) {
            req.setAttribute("s", user);
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }else {
            resp.sendRedirect(contextPath+"/login.jsp");


        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
