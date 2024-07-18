package dzholdoshbaev.jobsearch.model;

import java.time.LocalDate;

public class Education_info {
    private int id;
    private int resume_id;
    private String institution;
    private String program;
    private LocalDate start_date;
    private LocalDate end_date;
    private String degree;

    public Education_info(int id, int resume_id, String institution, String program, LocalDate start_date, LocalDate end_date, String degree) {
        this.id = id;
        this.resume_id = resume_id;
        this.institution = institution;
        this.program = program;
        this.start_date = start_date;
        this.end_date = end_date;
        this.degree = degree;
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

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "Education_info{" +
                "id=" + id +
                ", resume_id=" + resume_id +
                ", institution='" + institution + '\'' +
                ", program='" + program + '\'' +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                ", degree='" + degree + '\'' +
                '}';
    }
}
