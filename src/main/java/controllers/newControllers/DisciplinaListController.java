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


@WebServlet(name = "DisciplinaListController", urlPatterns = "/disciplina-list-cont")
public class DisciplinaListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Disciplina> disciplinas = DatabaseServices.getAllDisciplines();
        req.setAttribute("disciplinalist", disciplinas);
        req.getRequestDispatcher("/WEB-INF/jsp/newJsp/disciplina-list.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idsDeleteDosciplines = req.getParameter("idRemoveDisciplineHidden");
       String [] deleteDis = idsDeleteDosciplines.split(",");
       DatabaseServices.deleteDiscipline(deleteDis);
       resp.sendRedirect("/disciplina-list-cont");
    }
}
