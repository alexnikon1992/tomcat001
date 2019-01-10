package entity;

public class Mark {
    private Student student;
    private Term term;
    private Disciplina disciplina;
    private int mark;

    public Mark() {
    }

    public Mark(Student student, Term term, Disciplina disciplina, int mark) {
        this.student = student;
        this.term = term;
        this.disciplina = disciplina;
        this.mark = mark;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Term getTerm() {
        return term;
    }

    public void setTerm(Term term) {
        this.term = term;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mark mark1 = (Mark) o;

        if (mark != mark1.mark) return false;
        if (student != null ? !student.equals(mark1.student) : mark1.student != null) return false;
        if (term != null ? !term.equals(mark1.term) : mark1.term != null) return false;
        return disciplina != null ? disciplina.equals(mark1.disciplina) : mark1.disciplina == null;
    }

    @Override
    public int hashCode() {
        int result = student != null ? student.hashCode() : 0;
        result = 31 * result + (term != null ? term.hashCode() : 0);
        result = 31 * result + (disciplina != null ? disciplina.hashCode() : 0);
        result = 31 * result + mark;
        return result;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "student=" + student +
                ", term=" + term +
                ", disciplina=" + disciplina +
                ", mark=" + mark +
                '}';
    }
}
