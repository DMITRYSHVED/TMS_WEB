package dataBaseServletTask;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FirstFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        if (req.getMethod().equalsIgnoreCase("POST")){
            String userName = req.getParameter("userName");
            String userSurname = req.getParameter("userSurname");
            if (userName == null || userName.isEmpty() || userSurname == null || userSurname.isEmpty()) {
                resp.sendRedirect(req.getContextPath() + "/home");
                return;
            }
        }
            chain.doFilter(request,response);
    }
}
