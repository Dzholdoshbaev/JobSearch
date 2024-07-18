package dzholdoshbaev.jobsearch.model;

public class Contacts_info {
    private int id;
    private String value;
    private int resume_id;
    private int type_id;

    public Contacts_info(int id, String value, int resume_id, int type_id) {
        this.id = id;
        this.value = value;
        this.resume_id = resume_id;
        this.type_id = type_id;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    @Override
    public String toString() {
        return "Contacts_info{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", resume_id=" + resume_id +
                ", type_id=" + type_id +
                '}';
    }
}
