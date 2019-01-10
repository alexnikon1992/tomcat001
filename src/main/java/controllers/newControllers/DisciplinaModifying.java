package controllers.newControllers;

import database.DatabaseServices;
import entity.Disciplina;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "DisciplinaModifying", urlPatterns = "/disciplina-modifying")
public class DisciplinaModifying extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idDis = req.getParameter("isDeleteDis");
        Disciplina disciplina = DatabaseServices.getDisciplinaById(Integer.parseInt(idDis));
        req.setAttribute("dis", disciplina);
        req.getRequestDispatcher("/WEB-INF/jsp/newJsp/disciplina-modifying.jsp").forward(req,resp);
    }
}
