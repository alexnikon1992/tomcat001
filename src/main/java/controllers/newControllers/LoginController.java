package controllers.newControllers;

import database.DatabaseServices;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginController", urlPatterns = "/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/newJsp/password.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String pass = req.getParameter("pass");
        String role = req.getParameter("role");
        User user = DatabaseServices.getUserByLoginPassRole(login, pass, Integer.parseInt(role));
        if (user.getId() == -1) {
            req.setAttribute("message", 1);
            req.getRequestDispatcher("/WEB-INF/jsp/newJsp/password.jsp").forward(req, resp);
        }
        req.getSession().setAttribute("isLogin", "true");
        req.getSession().setAttribute("role",role);
        resp.sendRedirect("/");
    }
}
