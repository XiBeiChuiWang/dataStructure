public class Main {
    public static void main(String[] args) {
        Person person = new Person("1", 1);
        Person person1 = new Person("2", 1);
        Person person2 = new Person("3", 1);
        Person person3 = new Person("4", 1);
        Person person4 = new Person("5", 1);
        Person person5 = new Person("6", 1);
        Person[] p = new Person []{person,person1,person2,person3,person4,person5};
        Quick<Person> personQuick = new Quick<>(p);

        personQuick.union(person1,person2);
        personQuick.union(person1,person3);
        System.out.println(personQuick.isConnected(person1,new Person("3", 1)));
        System.out.println(personQuick.isConnected(person2,new Person("66", 1)));


    }
}
