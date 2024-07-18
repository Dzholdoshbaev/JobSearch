package dzholdoshbaev.jobsearch.model;

public class Responded_applicants {
    private int id;
    private int resume_id;
    private int vacancy_id;
    private boolean confirmation;

    public Responded_applicants(int id, int resume_id, int vacancy_id, boolean confirmation) {
        this.id = id;
        this.resume_id = resume_id;
        this.vacancy_id = vacancy_id;
        this.confirmation = confirmation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getResume_id() {
        return resume_id;
    }

    public void setResume_id(int resume_id) {
        this.resume_id = resume_id;
    }

    public int getVacancy_id() {
        return vacancy_id;
    }

    public void setVacancy_id(int vacancy_id) {
        this.vacancy_id = vacancy_id;
    }

    public boolean isConfirmation() {
        return confirmation;
    }

    public void setConfirmation(boolean confirmation) {
        this.confirmation = confirmation;
    }

    @Override
    public String toString() {
        return "Responded_applicants{" +
                "id=" + id +
                ", resume_id=" + resume_id +
                ", vacancy_id=" + vacancy_id +
                ", confirmation=" + confirmation +
                '}';
    }
}
