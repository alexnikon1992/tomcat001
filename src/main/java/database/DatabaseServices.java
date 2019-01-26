package database;
import constants.Constant;
import entity.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DatabaseServices {
    public static void main(String[] args) {
        System.out.println(getAllStudents());
    }

    public static List<Student> getAllStudents() {
        ArrayList<Student> students = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constant.PATH_TO_DATABASE);            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM student where status = '1';");
            while (result.next()) {
                Student student = new Student();
                student.setId(result.getInt("id"));
                student.setSurname(result.getString("surname"));
                student.setGroup(result.getString("group"));
                student.setDate(result.getDate("date"));
                student.setName(result.getString("name"));
                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    public static void studentModifying(int id, String surname, String name, String group, String date) {
        try {
            Connection conn = DriverManager.getConnection(Constant.PATH_TO_DATABASE);
            Statement statement = conn.createStatement();
            statement.execute("UPDATE `student` SET `surname` = '" + surname + "', `name` = '" + name + "', `group` = '" + group + "', `date` = '" + date + "' WHERE (`id` = '" + id + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteDiscipline(String[]idsDelete) {
        try {
            Connection conn = DriverManager.getConnection(Constant.PATH_TO_DATABASE);
            Statement statement = conn.createStatement();
            for(int i=0; i<idsDelete.length; i++ ){
                statement.execute("UPDATE `disciplina` SET `status` = '0' WHERE (`id` = '"+idsDelete[i]+"');");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteStudent(String[]idsDelete) {
        try {
            Connection conn = DriverManager.getConnection(Constant.PATH_TO_DATABASE);
            Statement statement = conn.createStatement();
            for(int i=0; i<idsDelete.length; i++ ){
                statement.execute("UPDATE `student` SET `status` = '0' WHERE (`id` = '"+idsDelete[i]+"');");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void studentCreating(String surname, String name, String group, String date) {
        try {
            Connection conn = DriverManager.getConnection(Constant.PATH_TO_DATABASE);
            Statement statement = conn.createStatement();
            statement.execute("INSERT INTO `student` (`surname`, `name`, `group`, `date`, `status`) VALUES ('" + surname + "', '" + name + "', '" + group + "', '" + date + "', '1')");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static List<Disciplina> getAllDisciplines() {
        ArrayList<Disciplina> disciplinas = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constant.PATH_TO_DATABASE);
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM disciplina where status = '1';");
            while (result.next()) {
                Disciplina disciplina = new Disciplina();
                disciplina.setId(result.getInt("id"));
                disciplina.setDisciplina(result.getString("disciplina"));
                disciplinas.add(disciplina);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return disciplinas;
    }

    public static void disciplineCreating(String disciplina) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constant.PATH_TO_DATABASE);
            Statement statement = conn.createStatement();
            statement.execute("INSERT INTO `disciplina` (`disciplina`, `status`) VALUES ('" + disciplina + "', '1')");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void disciplineModifying(String disciplina, String id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constant.PATH_TO_DATABASE);
            Statement statement = conn.createStatement();
            statement.execute("UPDATE `disciplina` SET `disciplina` = '" + disciplina + "' WHERE (`id` = '"+id+"')");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static List<Term> getAllTerms() {
        ArrayList<Term> terms = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constant.PATH_TO_DATABASE);
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM term where status = '1';");
            while (result.next()) {
                Term term = new Term();
                term.setId(result.getInt("id"));
                term.setName(result.getString("name"));
                term.setDuration(result.getString("duration"));
                terms.add(term);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return terms;
    }

    public static List<Disciplina> getDisciplineSemestr(int idSemestra) {
        ArrayList<Disciplina> disciplinas = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constant.PATH_TO_DATABASE);
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM term_disciplina \n" +
                    "left join disciplina on id_disciplina = disciplina.id\n" +
                    "where id_term = '" + idSemestra + "'");
            while (result.next()) {
                Disciplina disciplina = new Disciplina();
                disciplina.setId(result.getInt("id_disciplina"));
                disciplina.setDisciplina(result.getString("disciplina"));
                disciplinas.add(disciplina);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return disciplinas;
    }

    public static int termCreating(String name, String duration) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constant.PATH_TO_DATABASE);
            Statement statement = conn.createStatement();
            statement.execute("INSERT INTO `term` (`name`, `duration`) VALUES ('" + name + "', '" + duration + "')");
            ResultSet result = statement.executeQuery("SELECT LAST_INSERT_ID();");
            while (result.next()) {
                return result.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static void addDisciplinesToSemestr(int idSemestra, String[] idsDiscipline) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constant.PATH_TO_DATABASE);
            Statement statement = conn.createStatement();
            for (String iddiscipline : idsDiscipline) {
                statement.execute("INSERT INTO `term_disciplina` (`id_term`, `id_disciplina`) VALUES ('" + idSemestra + "', '" + iddiscipline + "')");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void deleteDisciplinesFromSemestr(int idSemestra) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constant.PATH_TO_DATABASE);
            Statement statement = conn.createStatement();
            statement.execute("DELETE FROM `term_disciplina` WHERE (`id_term` = '" + idSemestra + "')");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void modifyTermDuration(String duration, int idSemestra) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constant.PATH_TO_DATABASE);
            Statement statement = conn.createStatement();
            statement.execute("UPDATE `students`.`term` SET `duration` = '" + duration + "' WHERE (`id` = '" + idSemestra + "')");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Student getStudentById(int id) {
        Student student = new Student();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constant.PATH_TO_DATABASE);
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM student where status = '1' and id = '"+id+"';");
            while (result.next()) {
                student.setId(result.getInt("id"));
                student.setSurname(result.getString("surname"));
                student.setGroup(result.getString("group"));
                student.setDate(result.getDate("date"));
                student.setName(result.getString("name"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

    public static Disciplina getDisciplinaById(int id) {
        Disciplina disciplina = new Disciplina();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constant.PATH_TO_DATABASE);
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM disciplina where id = '"+id+"';");
            while (result.next()) {
                disciplina.setId(result.getInt("id"));
                disciplina.setDisciplina(result.getString("disciplina"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return disciplina;
    }

    public static Term getTermById(int id) {
        Term term = new Term();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constant.PATH_TO_DATABASE);
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM term where id = '"+id+"';");
            while (result.next()) {
                term.setId(result.getInt("id"));
                term.setName(result.getString("name"));
                term.setDuration(result.getString("duration"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return term;
    }

    public static List<Role> getAllRoles() {
        ArrayList<Role> roles = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constant.PATH_TO_DATABASE);
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM role");
            while (result.next()) {
                Role role = new Role();
                role.setId(result.getInt("id"));
                role.setRole(result.getString("roli"));
                roles.add(role);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return roles;
    }

    public static User getUserByLoginPassRole (String login, String password, int idRoli) {
        User user = new User();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constant.PATH_TO_DATABASE);
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM students.user where login = '"+login+"' and password = '"+password+"' and id_roli = '"+idRoli+"'");
            while (result.next()) {
                user.setId(result.getInt("id"));
                user.setLogin(result.getString("login"));
                user.setPassword(result.getString("password"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
    public static List<Mark> getAllMarks(int idStudent, int idTerm) {
        ArrayList<Mark> marks = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constant.PATH_TO_DATABASE);
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM mark\n" +
                    "left join term_disciplina on id_term_disciplina = term_disciplina.id\n" +
                    "left join disciplina on term_disciplina.id_disciplina = disciplina.id\n" +
                    " where id_student = '"+idStudent+"' and term_disciplina.id_term = '"+idTerm+"'");
            while (result.next()) {
                Mark mark = new Mark();
                mark.setMark(result.getInt("mark"));
                Disciplina disciplina = new Disciplina();
                disciplina.setId(result.getInt("id_disciplina"));
                disciplina.setDisciplina(result.getString("disciplina"));
                mark.setDisciplina(disciplina);
                marks.add(mark);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return marks;
    }



}
