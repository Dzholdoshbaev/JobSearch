package dzholdoshbaev.jobsearch.model;

import java.time.LocalDateTime;

public class Resumes {
    private int id;
    private int applicant_id;
    private String name;
    private int category_id;
    private double salary;
    private boolean is_active;
    private LocalDateTime  created_date;
    private LocalDateTime update_time;

    public Resumes(int id, int applicant_id, String name, int category_id, double salary, boolean is_active, LocalDateTime created_date, LocalDateTime update_time) {
        this.id = id;
        this.applicant_id = applicant_id;
        this.name = name;
        this.category_id = category_id;
        this.salary = salary;
        this.is_active = is_active;
        this.created_date = created_date;
        this.update_time = update_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getApplicant_id() {
        return applicant_id;
    }

    public void setApplicant_id(int applicant_id) {
        this.applicant_id = applicant_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public LocalDateTime getCreated_date() {
        return created_date;
    }

    public void setCreated_date(LocalDateTime created_date) {
        this.created_date = created_date;
    }

    public LocalDateTime getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(LocalDateTime update_time) {
        this.update_time = update_time;
    }
}
