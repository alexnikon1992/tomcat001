package controllers.newControllers;

import database.DatabaseServices;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;
import java.io.IOException;
import java.util.List;

@WebServlet (name = "StudentsListController", urlPatterns = "/studets")
public class StudentsListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> students = DatabaseServices.getAllStudents();
        req.setAttribute("studentlist", students);
        req.getRequestDispatcher("/WEB-INF/jsp/newJsp/student-list.jsp").forward(req,resp);
    }
}
