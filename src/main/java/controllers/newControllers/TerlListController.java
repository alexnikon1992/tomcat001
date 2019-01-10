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

@WebServlet(name = "TerlListController", urlPatterns = "/term-list")
public class TerlListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Term> terms = DatabaseServices.getAllTerms();
        List<Disciplina> disciplinas = DatabaseServices.getDisciplineSemestr(terms.get(0).getId());
        req.setAttribute("termlist", terms);
        req.setAttribute("selectedterm", terms.get(0));
        req.setAttribute("disciplines", disciplinas);
        req.getRequestDispatcher("/WEB-INF/jsp/newJsp/term-list.jsp").forward(req, resp);
    }


}
