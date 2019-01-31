package controllers.newControllers;

import database.DatabaseServices;
import entity.Disciplina;
import entity.Mark;
import entity.Student;
import entity.Term;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="ViewStudentProgressController", urlPatterns = "/student-progress")
public class ViewStudentProgressController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("idsViewPrograssHidden");
        Student student =  DatabaseServices.getStudentById(Integer.parseInt(id));
        List<Term> terms = DatabaseServices.getAllTerms();
        Term selectTerm = terms.get(0);
        List<Mark> marks = DatabaseServices.getAllMarks(Integer.parseInt(id),selectTerm.getId());
        int summaMarks = 0;
        for (int i = 0; i < marks.size(); i++){
            summaMarks = summaMarks + marks.get(i).getMark();
        }
        double srednee = 0;
        if (marks.size()!=0){
           srednee = summaMarks/marks.size();
        }
        req.setAttribute("srednee", srednee);
        req.setAttribute("termsAll", terms);
        req.setAttribute("progressStudent", student);
        req.setAttribute("marks", marks);
        req.getRequestDispatcher("/WEB-INF/jsp/newJsp/studentprog.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idSelectedTerm = req.getParameter("selectTerm");
        String idStudent = req.getParameter("idStudent");
        Student student = DatabaseServices.getStudentById(Integer.parseInt(idStudent));
        List<Term> terms = DatabaseServices.getAllTerms();
        Term selectTerm = DatabaseServices.getTermById(Integer.parseInt(idSelectedTerm));
        List<Mark> marks = DatabaseServices.getAllMarks(Integer.parseInt(idStudent),Integer.parseInt(idSelectedTerm));
        int summaMarks = 0;
        for (int i= 0; i<marks.size(); i++){
            summaMarks = summaMarks +marks.get(i).getMark();
        }
        double srednee = 0;
        if (marks.size()!=0){
            srednee = summaMarks/marks.size();
        }
        req.setAttribute("srednee", srednee);
        req.setAttribute("termsAll", terms);
        req.setAttribute("progressStudent", student);
        req.setAttribute("marks", marks);
        req.setAttribute("selecteTerm", selectTerm);
        req.getRequestDispatcher("/WEB-INF/jsp/newJsp/studentprog.jsp").forward(req, resp);

    }
}
