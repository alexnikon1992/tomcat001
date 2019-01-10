package controllers.newControllers;

import database.DatabaseServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "StudentCreatingController", urlPatterns = "/student-create")
public class StudentCreatingController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("message", 0);
        req.getRequestDispatcher("/WEB-INF/jsp/newJsp/student-creating.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String surname = req.getParameter("surname");
        String name = req.getParameter("name");
        String group = req.getParameter("group");
        String date = req.getParameter("date");

        if (surname == null || name == null || group == null || date == null){
            req.setAttribute("message", 1);
            req.getRequestDispatcher("/WEB-INF/jsp/newJsp/student-creating.jsp").forward(req, resp);
        }

        if (surname.equals("") || name.equals("") || group.equals("") || date.equals("")){
            req.setAttribute("message", 1);
            req.getRequestDispatcher("/WEB-INF/jsp/newJsp/student-creating.jsp").forward(req, resp);
        }

        DatabaseServices.studentCreating(surname, name, group, date);
        resp.sendRedirect("/studets");
    }
}
