package controllers;


import entity.Disciplina;
import entity.Term;

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

@WebServlet(name = "TermModifiController", urlPatterns = "/term-modifi")
public class TermModifiController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idTerm = req.getParameter("idSelectedTerm");
        ArrayList<Disciplina> disciplinasFromSelTerm = new ArrayList<>();
        Term term = new Term();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students?user=root&password=1212a&useLegacyDatetimeCode=false&amp&serverTimezone=Europe/Amsterdam&amp&useSSL=false");
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM term where status = '1' and id = '"+idTerm+"';");
            while (result.next()){
                term.setId(result.getInt("id"));
                term.setName(result.getString("name"));
                term.setDuration(result.getString("duration"));
            }


            result = statement.executeQuery("SELECT * FROM term_disciplina \n" +
                    "left join disciplina on term_disciplina.id_disciplina = disciplina.id\n" +
                    "where id_term='"+idTerm+"' and disciplina.status = '1'");
            while (result.next()){
                Disciplina disciplina = new Disciplina();
                disciplina.setId(result.getInt(4));
                disciplina.setDisciplina(result.getString("disciplina"));
                disciplinasFromSelTerm.add(disciplina);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        req.setAttribute("disciplinasFromSelTerm", disciplinasFromSelTerm);
        req.setAttribute("currentTerm", term);
        req.getRequestDispatcher("/WEB-INF/jsp/student-modify.jsp").forward(req, resp);
    }
}
