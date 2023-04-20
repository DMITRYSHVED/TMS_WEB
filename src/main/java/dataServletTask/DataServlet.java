package dataServletTask;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

@WebServlet("/date")
public class DataServlet extends HttpServlet {

    //Logger logger = LogManager.getLogger();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int year = Integer.parseInt(req.getParameter("year"));
        int month = Integer.parseInt(req.getParameter("month"));
        int monthDay = Integer.parseInt(req.getParameter("day")) ;
        LocalDate localDate = LocalDate.of(year,month,monthDay);;

        req.setAttribute("year",year);
        req.setAttribute("month",month);
        req.setAttribute("day",monthDay);
        req.setAttribute("weekDay",localDate.getDayOfWeek());
        getServletContext().getRequestDispatcher("/WEB-INF/date.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/date.jsp").forward(req,resp);
    }
}


