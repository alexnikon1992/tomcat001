package controllers.newControllers;

import database.DatabaseServices;
import entity.Disciplina;
import entity.Term;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="TermModifyController", urlPatterns = "/term-list-modify")
public class TermModifyController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idTerm = req.getParameter("idTermModify");
        Term term = DatabaseServices.getTermById(Integer.parseInt(idTerm));
        List<Disciplina> allDisciplines = DatabaseServices.getAllDisciplines();
        req.setAttribute("termSelect", term);
        req.setAttribute("allDisc", allDisciplines);
        req.getRequestDispatcher("/WEB-INF/jsp/newJsp/term-modify.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String duration = req.getParameter("duration");
        String [] idsDisciplines = req.getParameterValues("idDisciplines");
        String selectTerm = req.getParameter("selectTermId");

        if (duration.equals("") || idsDisciplines.length == 0){
            List<Disciplina> disciplinas = DatabaseServices.getAllDisciplines();
            req.setAttribute("allDisc", disciplinas);
            Term term = DatabaseServices.getTermById(Integer.parseInt(selectTerm));
            req.setAttribute("termSelect", term);
            req.setAttribute("message", 1);
            req.getRequestDispatcher("/WEB-INF/jsp/newJsp/term-modify.jsp").forward(req, resp);
        }

        DatabaseServices.modifyTerm(duration,Integer.parseInt(selectTerm));
        DatabaseServices.deleteDisciplinesFromSemestr(Integer.parseInt(selectTerm));
        DatabaseServices.addDisciplinesToSemestr(Integer.parseInt(selectTerm),idsDisciplines);
        resp.sendRedirect("/term-list");
    }
}
