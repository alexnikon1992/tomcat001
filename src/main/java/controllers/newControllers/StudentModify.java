package controllers.newControllers;

import database.DatabaseServices;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StudentModify", urlPatterns = "/studet-modify")

public class StudentModify extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStudent = req.getParameter("idsModifyStudentHidden");
        Student student = DatabaseServices.getStudentById(Integer.parseInt(idStudent));
        req.setAttribute("studentselect", student);
        req.getRequestDispatcher("/WEB-INF/jsp/newJsp/student-modify.jsp").forward(req,resp);

    }
}
