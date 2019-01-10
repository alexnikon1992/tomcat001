package controllers.newControllers;

import database.DatabaseServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DisciplineCreatingController", urlPatterns = "/disciplina-creating")
public class DisciplineCreatingController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/newJsp/disciplina-creating.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String disciplina = req.getParameter("disciplina");
        if (disciplina == null) {
            req.setAttribute("message", 1);
            req.getRequestDispatcher("/WEB-INF/jsp/newJsp/disciplina-creating.jsp").forward(req, resp);
        } else if (disciplina.equals("")) {
            req.setAttribute("message", 1);
            req.getRequestDispatcher("/WEB-INF/jsp/newJsp/disciplina-creating.jsp").forward(req, resp);
        }else {
            DatabaseServices.disciplineCreating(disciplina);
            resp.sendRedirect("/disciplina-list-cont");
        }


    }

}
