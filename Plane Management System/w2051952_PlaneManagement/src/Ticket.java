import java.io.FileWriter;
import java.io.IOException;

// Task 8: Creating a new class file called "Ticket".
public class Ticket {
   // Task 8: Adding the attributes.
    private char row;
    private int price, seat;
    private Person person;

    // Task 8: Adding the constructors.

    public Ticket(char row, int price, int seat, Person person) {
        this.row = row;
        this.price = price;
        this.seat = seat;
        this.person = person;
    }

    //Task 8: Adding the getters & setters.
    public char getRow() {
        return row;
    }

    public void setRow(char row) {
        this.row = row;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void ticket_information(){
        //Task 8: This method prints out the information of the Ticket including the information of the Person.
        System.out.println("\nTicket Information: ");
        System.out.println("\tRow: " + getRow());
        System.out.println("\tSeat: " + getSeat());
        System.out.println("\tPrice: " + getPrice());

        //Task 8: Calling personal_information() method from "Person" to print out the information of the Person.
        person.personal_information();
    }

    public void save(){
        //Task 12: Saves the ticket information to a text file.
        try{
            FileWriter file = new FileWriter(getRow()+""+getSeat()+".txt");
            file.write("Ticket information for the seat: \n");
            file.write("\tRow: " + getRow()+"\n");
            file.write("\tSeat: " + getSeat()+"\n");
            file.write("\tPrice: " + getPrice()+"\n");
            file.write("Passenger information: "+"\n");
            file.write("\tName: " + person.getName()+"\n");
            file.write("\tSurname: " + person.getSurname()+"\n");
            file.write("\tEmail: " + person.getEmail()+"\n");
            file.close();

        }
        catch (IOException e){
            System.out.println("The text file is not created.");
        }

    }
}
