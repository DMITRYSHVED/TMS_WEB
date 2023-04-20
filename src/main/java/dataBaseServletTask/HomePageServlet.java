package dataBaseServletTask;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/home")
public class HomePageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        Integer count = (Integer) session.getAttribute("count");

        if (count == null) {
            count = 1;
        } else {
            count++;
        }
        session.setAttribute("count", count);
        getServletContext().getRequestDispatcher("/home.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            user = new User();
            user.setName(req.getParameter("userName"));
            user.setSurname(req.getParameter("userSurname"));
        }
        session.setAttribute("user", user);
        resp.sendRedirect("/students");
    }
}
