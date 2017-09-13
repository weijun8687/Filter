package filter;

import javax.servlet.*;
import java.io.IOException;

public class FilterDemo1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

//        String encoder = "UTF-8";
//        servletRequest.setCharacterEncoding(encoder);
//        servletResponse.setCharacterEncoding(encoder);
//        servletResponse.setContentType("");

    }

    @Override
    public void destroy() {

    }
}
