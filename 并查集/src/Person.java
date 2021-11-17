import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return critical == person.critical &&
                name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, critical);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", critical=" + critical +
                '}';
    }
}
