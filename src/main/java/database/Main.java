package database;

import entity.Disciplina;

import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students?user=root&password=1212a&useLegacyDatetimeCode=false&amp&serverTimezone=Europe/Amsterdam&amp&useSSL=false");
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM disciplina;");
            ArrayList<Disciplina>disciplinas = new ArrayList<Disciplina>();
            while (result.next()){
                Disciplina disciplina = new Disciplina();
                disciplina.setId(result.getInt("id"));
               disciplina.setDisciplina(result.getString("disciplina"));
               disciplinas.add(disciplina);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
