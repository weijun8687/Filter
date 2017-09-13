package filter;

import domain.User;
import service.BusinessService;
import service.impl.BusinessServiceImpl;
import util.SecurityUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.ResultSet;

// 自动登录的过滤器
public class AutoLoginFilter implements Filter {

    private BusinessService service = new BusinessServiceImpl();
    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request;
        HttpServletResponse response;
        try {
            request = (HttpServletRequest) servletRequest;
            response = (HttpServletResponse) servletResponse;
        } catch (Exception e) {
            throw new ServletException("non-HTTP request or response");
        }

        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");

        if (sessionUser == null) {
            Cookie loginCookie = null;
            Cookie cs[] = request.getCookies();
            for (int i = 0; i < cs.length; i++) {
                if ("loginInfo".equals(cs[i].getName())) {
                    loginCookie = cs[i];
                    break;
                }
            }

            if (loginCookie != null) {
                String value = loginCookie.getValue();
                // 再次向数据库验证
                String name = SecurityUtil.base64decode(value.split("_")[0]);
                String password = value.split("_")[1];
                User user = service.login(name, password);
                if (user != null){
                    session.setAttribute("user", user);
                }

            }
        }
        // 不管登录与否, 都必须放行
        filterChain.doFilter(request, response);

    }

    @Override
    public void destroy() {

    }
}
