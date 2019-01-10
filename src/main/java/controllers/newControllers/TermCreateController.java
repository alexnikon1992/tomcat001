package controllers.newControllers;

import database.DatabaseServices;
import entity.Disciplina;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TermCreateController", urlPatterns = "/term-create")
public class TermCreateController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("message", 0);
        List<Disciplina> disciplinas = DatabaseServices.getAllDisciplines();
        req.setAttribute("disciplina", disciplinas);
        req.getRequestDispatcher("/WEB-INF/jsp/newJsp/term-creating.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String duration = req.getParameter("duration");
        String[] idsDisciplines = req.getParameterValues("selectdiscipline");
        int idSemestr = DatabaseServices.termCreating("Сесестр 5", duration);
        DatabaseServices.addDisciplinesToSemestr(idSemestr, idsDisciplines);
        resp.sendRedirect("/term-list");
    }
}
