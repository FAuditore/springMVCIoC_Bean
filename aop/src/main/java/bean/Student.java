package bean;

public class Student {

    private int id;
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public Student() {

    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }



}
