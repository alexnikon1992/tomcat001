package controllers;

import entity.Disciplina;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

@WebServlet(name = "DisciplinaCreateController", urlPatterns = "/disciplina-create")
public class DisciplinaCreateController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/jsp/studentprog.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String unputData = req.getParameter("name-disciplina");
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students?user=root&password=1212a&useLegacyDatetimeCode=false&amp&serverTimezone=Europe/Amsterdam&amp&useSSL=false");
            Statement statement = conn.createStatement();
            statement.execute("INSERT INTO `disciplina` (`disciplina`) VALUES ('"+unputData+"');");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/disciplines");
    }
}
