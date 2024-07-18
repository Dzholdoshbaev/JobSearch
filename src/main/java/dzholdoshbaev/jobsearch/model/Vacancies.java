package dzholdoshbaev.jobsearch.model;

import java.time.LocalDateTime;

public class Vacancies {
    private int id;
    private String name;
    private String description;
    private int category_id;
    private double salary;
    private int exp_from;
    private int exp_to;
    private boolean is_active;
    private int author_id;
    private LocalDateTime created_date;
    private LocalDateTime update_time;

    public Vacancies(String name, int id, String description, int category_id, double salary, int exp_from, int exp_to, boolean is_active, int author_id, LocalDateTime created_date, LocalDateTime update_time) {
        this.name = name;
        this.id = id;
        this.description = description;
        this.category_id = category_id;
        this.salary = salary;
        this.exp_from = exp_from;
        this.exp_to = exp_to;
        this.is_active = is_active;
        this.author_id = author_id;
        this.created_date = created_date;
        this.update_time = update_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public int getExp_from() {
        return exp_from;
    }

    public void setExp_from(int exp_from) {
        this.exp_from = exp_from;
    }

    public int getExp_to() {
        return exp_to;
    }

    public void setExp_to(int exp_to) {
        this.exp_to = exp_to;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
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

    @Override
    public String toString() {
        return "Vacancies{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category_id=" + category_id +
                ", salary=" + salary +
                ", exp_from=" + exp_from +
                ", exp_to=" + exp_to +
                ", is_active=" + is_active +
                ", author_id=" + author_id +
                ", created_date=" + created_date +
                ", update_time=" + update_time +
                '}';
    }
}
