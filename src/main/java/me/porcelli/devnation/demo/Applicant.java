package me.porcelli.devnation.demo;

public class Applicant {

    private String name;
    private int age;
    private String id;

    public Applicant() {
    }

    public Applicant(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Applicant)) {
            return false;
        }
        Applicant applicant = (Applicant) o;
        return id.equals(applicant.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "{" + " name='" + getName() + "'" + ", age='" + getAge() + "'" + ", id='" + getId() + "'" + "}";
    }

}
