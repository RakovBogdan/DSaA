package chapter02;

class Person {

    private String lastName;
    private String firstName;
    private int age;

    public Person(String lastName, String firstName, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
    }

    public void displayPerson() {
        System.out.println(
                "Last Name: " + this.lastName + ", First Name: " + this.firstName + ", age: " + this.age);
    }

    public String getLastName() {
        return this.lastName;
    }
}