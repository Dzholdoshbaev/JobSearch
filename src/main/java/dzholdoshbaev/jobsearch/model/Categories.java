package dzholdoshbaev.jobsearch.model;

public class Categories {
    private int id;
    private String name;
    private int parent_id_categories;

    public Categories(int id, String name, int parent_id_categories) {
        this.id = id;
        this.name = name;
        this.parent_id_categories = parent_id_categories;
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

    public int getParent_id_categories() {
        return parent_id_categories;
    }

    public void setParent_id_categories(int parent_id_categories) {
        this.parent_id_categories = parent_id_categories;
    }

    @Override
    public String toString() {
        return "Categories{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parent_id_categories=" + parent_id_categories +
                '}';
    }
}
