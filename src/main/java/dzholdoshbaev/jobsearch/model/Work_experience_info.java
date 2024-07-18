package dzholdoshbaev.jobsearch.model;

public class Work_experience_info {
    private int id;
    private int resume_id;
    private int year;
    private String company_name;
    private String position ;
    private String responsibilities;

    public Work_experience_info(int id, int year, int resume_id, String company_name, String position, String responsibilities) {
        this.id = id;
        this.year = year;
        this.resume_id = resume_id;
        this.company_name = company_name;
        this.position = position;
        this.responsibilities = responsibilities;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getResume_id() {
        return resume_id;
    }

    public void setResume_id(int resume_id) {
        this.resume_id = resume_id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getResponsibilities() {
        return responsibilities;
    }

    public void setResponsibilities(String responsibilities) {
        this.responsibilities = responsibilities;
    }

    @Override
    public String toString() {
        return "Work_experience_info{" +
                "id=" + id +
                ", resume_id=" + resume_id +
                ", year=" + year +
                ", company_name='" + company_name + '\'' +
                ", position='" + position + '\'' +
                ", responsibilities='" + responsibilities + '\'' +
                '}';
    }
}
