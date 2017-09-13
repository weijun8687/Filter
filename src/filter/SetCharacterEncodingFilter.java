package filter;

import javax.servlet.*;
import java.io.IOException;

public class SetCharacterEncodingFilter implements Filter {
    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 读取指定的参数
        String encode = filterConfig.getInitParameter("encoding");
        if (encode==null){
            // 设置默认值
            encode = "UTF-8";
        }
        servletRequest.setCharacterEncoding(encode);
        servletResponse.setCharacterEncoding(encode);
        servletResponse.setContentType("text/html, charset="+encode);

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
