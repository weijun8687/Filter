package web;

import domain.User;
import service.BusinessService;
import service.impl.BusinessServiceImpl;
import util.SecurityUtil;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    BusinessService service = new BusinessServiceImpl();
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = service.login(username, SecurityUtil.md5(password));

        if (user == null){
            resp.getWriter().write("用户名或密码错误");
            return;
        }

        HttpSession session = req.getSession();
        session.setAttribute("user",user);

        String remember = req.getParameter("remember");
        if (remember!=null){
            Cookie cookie = new Cookie("loginInfo",
                    SecurityUtil.base64decode(username)+"_"+SecurityUtil.md5(password));
            cookie.setMaxAge(Integer.MAX_VALUE);
            cookie.setPath(req.getContextPath());
            resp.addCookie(cookie);
        }

        // 重定向到主页
        resp.sendRedirect(req.getContextPath());

    }


    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
