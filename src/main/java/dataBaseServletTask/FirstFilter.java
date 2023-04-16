package dataBaseServletTask;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

public class FirstFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        PrintWriter printWriter = res.getWriter();

        if (validate(request.getParameter("userName"))&&validate(request.getParameter("userSurname"))){
            chain.doFilter(req,res);
        }else {
            printWriter.println("INVALID INPUT");
        }
    }

    protected static boolean validate(String parameter){
        if (parameter==null||parameter.isEmpty()){
            return false;
        }else {
            return true;
        }
    }
}
