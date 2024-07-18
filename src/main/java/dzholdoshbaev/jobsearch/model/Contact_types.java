package dzholdoshbaev.jobsearch.model;

public class Contact_types {
    private int id;
    private String type;

    public Contact_types(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Contact_types{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
