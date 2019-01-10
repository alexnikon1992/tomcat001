package entity;

public class Disciplina {

    private int id;
    private String disciplina;

    public Disciplina() {
    }

    public Disciplina(int id, String disciplina) {
        this.id = id;
        this.disciplina = disciplina;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Disciplina that = (Disciplina) o;

        if (id != that.id) return false;
        return disciplina != null ? disciplina.equals(that.disciplina) : that.disciplina == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (disciplina != null ? disciplina.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "id=" + id +
                ", disciplina='" + disciplina + '\'' +
                '}';
    }
}
