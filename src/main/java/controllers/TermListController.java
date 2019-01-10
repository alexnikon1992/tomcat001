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


@WebServlet(name = "TermListController", urlPatterns = "/terms")

public class TermListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Term> terms = new ArrayList<>();
        ArrayList<Disciplina> disciplinasFromSelTerm = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students?user=root&password=1212a&useLegacyDatetimeCode=false&amp&serverTimezone=Europe/Amsterdam&amp&useSSL=false");
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM term where status = '1';");
            while (result.next()){
                Term term = new Term();
                term.setId(result.getInt("id"));
                term.setName(result.getString("name"));
                term.setDuration(result.getString("duration"));
                terms.add(term);
            }


            result = statement.executeQuery("SELECT * FROM term_disciplina \n" +
                    "left join disciplina on term_disciplina.id_disciplina = disciplina.id\n" +
                    "where id_term='"+terms.get(0).getId()+"' and disciplina.status = '1'");
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
        req.setAttribute("terms", terms);
        req.setAttribute("selectedTerm", terms.get(0));
        req.getRequestDispatcher("/WEB-INF/jsp/term-list.jsp").forward(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id-selected-term");
        ArrayList<Term> terms = new ArrayList<>();
        ArrayList<Disciplina> disciplinasFromSelTerm = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students?user=root&password=1212a&useLegacyDatetimeCode=false&amp&serverTimezone=Europe/Amsterdam&amp&useSSL=false");
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM term where status = '1';");
            while (result.next()){
                Term term = new Term();
                term.setId(result.getInt("id"));
                term.setName(result.getString("name"));
                term.setDuration(result.getString("duration"));
                terms.add(term);
            }


            result = statement.executeQuery("SELECT * FROM term_disciplina \n" +
                    "left join disciplina on term_disciplina.id_disciplina = disciplina.id\n" +
                    "where id_term='"+idStr+"' and disciplina.status = '1'");
            while (result.next()){
                Disciplina disciplina = new Disciplina();
                disciplina.setId(result.getInt(4));
                disciplina.setDisciplina(result.getString("disciplina"));
                disciplinasFromSelTerm.add(disciplina);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        for (Term term:terms) {
            String currentIdStr = term.getId()+"";
            if (currentIdStr.equals(idStr)){
                req.setAttribute("selectedTerm", term);
            }
        }
        req.setAttribute("disciplinasFromSelTerm", disciplinasFromSelTerm);
        req.setAttribute("terms", terms);
        req.getRequestDispatcher("/WEB-INF/jsp/term-list.jsp").forward(req,resp);

    }
}
