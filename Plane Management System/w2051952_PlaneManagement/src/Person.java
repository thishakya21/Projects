// Task 7: Creating a new class file called "Person".
public class Person {
    // Task 7: Adding the attributes.
    private String name, surname, email;

    // Task 7: Adding the constructors.
    public Person(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    //Task 7: Adding getters & setters.
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void personal_information(){
        // Task 7: This method prints out the information from Person.
        System.out.println("\nPassenger Information:");
        System.out.println("\tName: " + getName());
        System.out.println("\tSurname: " + getSurname());
        System.out.println("\tEmail: " + getEmail());
    }
}
