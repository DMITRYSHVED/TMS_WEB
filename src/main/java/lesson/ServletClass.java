package lesson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/jsp")
public class ServletClass extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String stroka = req.getParameter("parameter");

        req.setAttribute("firstAtr",stroka);

        getServletContext().getRequestDispatcher("/hello.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("nameInput");
        int age = Integer.parseInt(req.getParameter("ageInput"));

        req.setAttribute("name",name);
        req.setAttribute("age",age);

        getServletContext().getRequestDispatcher("/hello.jsp").forward(req,resp);
    }
}
