public class TestPerson {
    public static void main(String[] args) {
        Person person = new Person("Bob", true);
        System.out.println("Hello, " + person.getName() + "!");
        System.out.println(person.isMarried());
    }
}
