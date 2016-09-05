package servlet;

import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

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
//            ConvertUtils.register(new Converter() {//注册一个日期转换器
//                @Override
//                public Object convert(Class aClass, Object value) {
//                    Date date = null;
//                    if (value instanceof String) {
//                        String dateString = (String) value;
//                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//                        try {
//                            date = sdf.parse(dateString);
//                        } catch (ParseException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                    return date;
//                }
//            }, Date.class);
            ConvertUtils.register(new DateLocaleConverter(), Date.class);
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
        resp.setHeader("refresh", "1;url=" + contextPath + "/index.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
