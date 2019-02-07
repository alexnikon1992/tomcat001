package controllers.newControllers;

import database.DatabaseServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="TermDeleteController", urlPatterns = "/term-list-delete")
public class TermDeleteController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idDelete = req.getParameter("idTermDelete");
        DatabaseServices.deleteDisciplinesFromSemestr(Integer.parseInt(idDelete));
        DatabaseServices.deleteSemestr(Integer.parseInt(idDelete));
        resp.sendRedirect("/term-list");
    }
}

