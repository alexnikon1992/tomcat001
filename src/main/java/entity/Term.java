package entity;

import java.util.ArrayList;

public class Term {
    private int id;
    private String name;
    private String duration;
    private ArrayList<Disciplina>disciplinas = new ArrayList<Disciplina>();

    public Term() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Term term = (Term) o;

        if (id != term.id) return false;
        if (name != null ? !name.equals(term.name) : term.name != null) return false;
        if (duration != null ? !duration.equals(term.duration) : term.duration != null) return false;
        return disciplinas != null ? disciplinas.equals(term.disciplinas) : term.disciplinas == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + (disciplinas != null ? disciplinas.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Term{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration='" + duration + '\'' +
                ", disciplinas=" + disciplinas +
                '}';
    }
}
