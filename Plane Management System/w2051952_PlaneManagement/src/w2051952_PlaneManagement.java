import java.util.InputMismatchException;
import java.util.Scanner;

public class w2051952_PlaneManagement {
    //Task 1: Creating the seats management array:
    public static int[][] seats = new int[4][];

    //Task 9: Creating the tickets array:
    public static Ticket[][] tickets = new Ticket[4][];

    public static void main(String[] args) {
        System.out.println("Welcome to the Plane Management application");

        //Task 1: Creating the seats management array:

        seats[0] = new int[14];
        seats[1] = new int[12];
        seats[2] = new int[12];
        seats[3] = new int[14];

        //Task 9: Creating the tickets array

        tickets[0] = new Ticket[14];
        tickets[1] = new Ticket[12];
        tickets[2] = new Ticket[12];
        tickets[3] = new Ticket[14];

        // Task 2: The menu is looped until the option is not 0.
        int option = -1;
        do {
            //Task 2: Prints out the user menu
            System.out.println("*********************************************");
            System.out.println("*               MENU OPTIONS                *");
            System.out.println("*********************************************");
            System.out.println("    1)  Buy a seat");
            System.out.println("    2)  Cancel a seat");
            System.out.println("    3)  Find first available seat");
            System.out.println("    4)  Show seating plan");
            System.out.println("    5)  Print tickets information and total sales");
            System.out.println("    6)  Search ticket");
            System.out.println("    0)  Quit");


            Scanner input = new Scanner(System.in);

            try {
                //Task 2: Allows the user to select an option from the menu
                System.out.print("Please select an option: ");
                option = input.nextInt();

                //Task 2: Executes the respective method based on the option chosen
                switch (option) {
                    case 1:
                        buy_seat();
                        break;
                    case 2:
                        cancel_seat();
                        break;
                    case 3:
                        find_first_available();
                        break;
                    case 4:
                        show_seating_plan();
                        break;
                    case 5:
                        print_tickets_info();
                        break;
                    case 6:
                        search_ticket();
                        break;
                    case 0:
                        System.out.println("The program is terminating.");
                        break;
                    default:
                        //If option is not within 0-6 an error message is displayed.
                        System.out.println("Invalid option. Please enter a number within 0-6.");
                }
            } catch (InputMismatchException e) {
                //If option is not within 0-6 an error message is displayed.
                System.out.println("Invalid option. Please enter a number within 0-6.");
                input.nextLine();
            }

        }
        while (option != 0);

    }


    public static void buy_seat() {
        //Task 3: This method allows the customer to buy the seat if the row letter and seat no are correct
        Scanner input = new Scanner(System.in);

        System.out.println("Row A and D has 14 seats each.");
        System.out.println("Row B and C has 12 seats each.");

        //Task 3: The row letter of the seat is obtained from the user.
        System.out.println("Enter the row letter to be purchased (A-D): ");
        char rowNo = input.next().toUpperCase().charAt(0);

        switch (rowNo) {
            //Task 3: Checks if the row letter is within A-D:
            case 'A', 'B', 'C', 'D':
                //Task 3: Allows the user to enter the Seat No if the Row letter is correct.
                System.out.println("Enter the seat number to be purchased : ");
                int seatNo = input.nextInt();
                input.nextLine();

                //Task 3: Converts the row letter to a numerical index.
                int rowIndex = rowNo - 'A';

                //Task 3: Checks if the Seat No is within the range based on the row.
                int condition;
                if (rowIndex == 0 || rowIndex == 3) {
                    condition = 14;
                } else {
                    condition = 12;
                }

                if (seatNo > 0 && seatNo <= condition) {
                    if (seats[rowIndex][seatNo - 1] == 0) {
                        seats[rowIndex][seatNo - 1] = 1;

                        //Task 9: Gets the user input for Personal information.
                        System.out.println("Enter your name: ");
                        String name = input.nextLine();

                        System.out.println("Enter your surname: ");
                        String surname = input.nextLine();

                        System.out.println("Enter your email: ");
                        String email = input.nextLine();

                        //Task 3: The seat is successfully booked if both seat No & row letter are correct.
                        System.out.println("The seat is successfully booked.");

                        Person person1 = new Person(name, surname, email);

                        //Task 9: Finding the prices based on the seat numbers
                        int price;
                        if (seatNo <= 5) {
                            price = 200;
                        } else if (seatNo <= 9) {
                            price = 150;
                        } else {
                            price = 180;
                        }

                        //Task 9: Adding ticket information to the tickets array
                        Ticket new_ticket = new Ticket(rowNo, price, seatNo, person1);
                        tickets[rowIndex][seatNo - 1] = new_ticket;

                        //Task 12: Prints the ticket information after the seat is booked.
                        new_ticket.save();

                    } else {
                        //Task 3: Prevents the user from booking a seat, that has already been booked previously.
                        System.out.println("This seat is already booked.");
                    }
                } else {
                    //Task 3: Prevents the user from entering an invalid Seat No.
                    System.out.println("Invalid seat number");
                }
                break;

            default:
                //Task 3: Prevents the user from entering an invalid Row Letter.
                System.out.println("Enter a valid row letter.");
        }
    }

    public static void cancel_seat() {
        //Task 4: This method allows the customer to cancel the seat if the row letter and seat no are correct.
        Scanner input = new Scanner(System.in);

        //Task 4: The row letter of the seat is obtained from the user.
        System.out.println("Enter the row number to be cancelled: ");
        char rowNo = input.next().toUpperCase().charAt(0);


        switch (rowNo) {
            case 'A', 'B', 'C', 'D':
                //Task 4: Allows the user to enter the Seat No if the Row letter is correct.
                System.out.println("Enter the seat number to be cancelled: ");
                int seatNo = input.nextInt();

                //Task 4: Converts the row letter to a numerical index.
                int rowIndex = rowNo - 'A';

                //Task 4: Checks if the Seat No is within the range based on the row.
                int condition;
                if (rowIndex == 0 || rowIndex == 3) {
                    condition = 14;
                } else {
                    condition = 12;
                }

                if (seatNo > 0 && seatNo <= condition) {
                    if (seats[rowIndex][seatNo - 1] == 1) {
                        seats[rowIndex][seatNo - 1] = 0;

                        //Task 9: Removes the ticket from the tickets array.
                        tickets[rowIndex][seatNo - 1] = null;

                        //Task 4: The seat is successfully cancelled if both seat No & row letter are correct.
                        System.out.println("The seat is successfully cancelled.");
                    } else {
                        //Task 4: Checks if the seat is already booked in order to be cancelled.
                        System.out.println("This seat was not booked previously.");
                    }
                } else {
                    //Task 4: Prevents the user from entering an invalid Seat No.
                    System.out.println("Invalid seat number.");
                }
                break;
            default:
                //Task 4: Prevents the user from entering an invalid Row Letter.
                System.out.println("Enter a valid row letter.");
        }
    }

    public static void show_seating_plan() {
        //Task 6: This method shows the seats that are still available and sold.
        System.out.println("Seating Plan:");

        //Task 6: Makes use of two "For Loops" to traverse through the two dimensional array for seats.
        for (int[] seat : seats) {
            for (int i : seat) {
                if (i == 0) {
                    System.out.print(" O ");
                } else {
                    System.out.print(" X ");
                }
            }
            System.out.println();
        }
    }

    public static void find_first_available() {
        //Task 5: This method allows the user to find the first seat which is still available.
        char row = 'A';

        //Task 5: Makes use of two "For Loops" to traverse through the two-dimensional array for seats.
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j] == 0) {
                    System.out.println("First available seat found at row " + (char) (row + i) + ", seat " + (j + 1));
                    return;
                }
            }
        }
    }

    public static void print_tickets_info() {
        //Task 10: This method prints the ticket information & total sales.
        double total = 0.0;

        //Task 10: Makes use of two "For Loops" to traverse through the two-dimensional array for tickets.
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < tickets[i].length; j++) {
                if (tickets[i][j] != null) {
                    tickets[i][j].ticket_information();
                    total = total + tickets[i][j].getPrice();
                    System.out.println("Total: " + total);
                }
            }
        }
    }

    public static void search_ticket() {
        //Task 11: This method allows the user to check if the seat is already booked or not.
        Scanner input = new Scanner(System.in);

        //Task 11: The row letter of the seat is obtained from the user.
        System.out.println("Enter the row letter (A-D): ");
        char rowNo = input.next().toUpperCase().charAt(0);

        switch (rowNo) {
            //Task 11: Checks if the row letter is within A-D:
            case 'A', 'B', 'C', 'D':
                //Task 11: Allows the user to enter the Seat No if the Row letter is correct.
                System.out.println("Enter the seat number :  ");
                int seatNo = input.nextInt();
                input.nextLine();

                //Task 11: Converts the row letter to a numerical index.
                int rowIndex = rowNo - 'A';


                //Task 11: Checks if the Seat No is within the range based on the row.
                int condition;

                if (rowIndex == 0 || rowIndex == 3) {
                condition = 14;
                } else {
                    condition = 12;
                }

            if (seatNo > 0 && seatNo <= condition) {
                //Task 11: Checks if the seat is available or not
                if (tickets[rowIndex][seatNo - 1] != null) {
                    tickets[rowIndex][seatNo - 1].ticket_information();
                    System.out.println("The ticket is available");
                } else {
                    System.out.println("This is seat is available to be booked.");
                }
            } else {
                //Task 11: Prevents the user from entering an invalid Seat No.
                System.out.println("Invalid seat number");
            }
            break;

            default:
                //Task 11: Prevents the user from entering an invalid Row Letter.
                System.out.println("Enter a valid row letter.");
        }
        
    }
}







