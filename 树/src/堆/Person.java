package 堆;

public class Person {
    private String name;
    private int critical;

    public Person(String name, int critical) {
        this.name = name;
        this.critical = critical;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCritical() {
        return critical;
    }

    public void setCritical(int critical) {
        this.critical = critical;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", critical=" + critical +
                '}';
    }
}
