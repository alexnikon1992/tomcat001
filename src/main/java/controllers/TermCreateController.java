package controllers;

import entity.Disciplina;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

@WebServlet(name = "TermCreateController", urlPatterns = "/terms-create")
public class TermCreateController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students?user=root&password=1212a&useLegacyDatetimeCode=false&amp&serverTimezone=Europe/Amsterdam&amp&useSSL=false");
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM disciplina where status = '1'");
            while (result.next()) {
                Disciplina disciplina = new Disciplina();
                disciplina.setId(result.getInt("id"));
                disciplina.setDisciplina(result.getString("disciplina"));
                disciplinas.add(disciplina);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        req.setAttribute("disciplines", disciplinas);
        req.getRequestDispatcher("/WEB-INF/jsp/term-creating.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dlitelnostSemestra = req.getParameter("duration");
        Object[] ids = req.getParameterValues("idSelectedDisciplines");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students?user=root&password=1212a&useLegacyDatetimeCode=false&amp&serverTimezone=Europe/Amsterdam&amp&useSSL=false");
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("SELECT MAX(id) FROM `term`");

            int lastId=0;
            while (result.next()) {
                lastId = result.getInt(1);
            }
            statement.execute("INSERT INTO `term` (`name`, `duration`, `status`) VALUES ('Семестр "+(lastId+1)+"', '" + dlitelnostSemestra + "', '1');");
            for (Object current:ids) {
                statement.execute("INSERT INTO `term_disciplina` (`id_term`, `id_disciplina`) VALUES ('"+(lastId+1)+"', '"+current+"');");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/terms");


    }
}
