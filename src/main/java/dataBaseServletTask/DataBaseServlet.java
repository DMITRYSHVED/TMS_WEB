package dataBaseServletTask;

import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/students")
public class DataBaseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FactoryManager factoryManager = FactoryManager.getManager();
        List<Student> studentsList;

        Session readSession = factoryManager.getSessionFactory().openSession();
        Transaction readTransaction = readSession.beginTransaction();
        studentsList = readSession.createQuery("FROM Student ").list();
        readTransaction.commit();
        readSession.close();

        req.setAttribute("studentsList", studentsList);
        getServletContext().getRequestDispatcher("/WEB-INF/students.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FactoryManager factoryManager = FactoryManager.getManager();

        Session writeSession = factoryManager.getSessionFactory().openSession();
        Transaction writeTransaction = writeSession.beginTransaction();
        Student student = new Student();
        student.setName(req.getParameter("name"));
        student.setSurname(req.getParameter("surname"));
        student.setTown(req.getParameter("town"));
        student.setAge(Integer.parseInt(req.getParameter("age")));
        writeSession.save(student);
        writeTransaction.commit();
        writeSession.close();

        resp.sendRedirect("/students");
    }
}
