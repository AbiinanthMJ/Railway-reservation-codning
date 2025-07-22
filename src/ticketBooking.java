import java.util.*;

public class ticketBooking {
    public static void main(String[] args) {
       TicketSystem ticketSystem = new TicketSystem();
       Scanner sc = new Scanner(System.in);
       while(true){
           System.out.println("Railway Booking System");
           System.out.println("1, Book Ticket");
           System.out.println("2, Cancek Ticket");
           System.out.println("3, view Confirmed Tickets");
           System.out.println("4, view Available Tickets");
           System.out.println("5, view RAC Tickets");
           System.out.println("6, view Waiting List Tickets");
           System.out.println("7, Exit");
           System.out.println("Enter your choice");
           int choice = sc.nextInt();
           sc.nextLine();
           switch (choice){
               case 1 :
                   System.out.print("Enter your Name");
                   String name = sc.nextLine();
                   System.out.print("Enter your age");
                   int age = sc.nextInt();
                   sc.nextLine();
                   System.out.print("Enter your gender (Male/Female)");
                   String gender = sc.nextLine();
                   System.out.println("Enter your Berth Perference");
                   String berthpreference = sc.nextLine();
                   ticketSystem.bookticket(name, age , gender , berthpreference);
               case 2 :
                   System.out.println("Enter your Ticket Id");
                   String ticketId=sc.nextLine();
                   ticketSystem.cancelticket(ticketId);
                   break;
               case 3 :
                   System.out.println("Viewing confirmed tickets");
                   ticketSystem.printBookedTickets();
                   break;
               case 4 :
                   System.out.println("Viewing Available Ticket ");
                   ticketSystem.printAvailableTicket();
               case 5 :
                   System.out.println("Viewing RAC tickets");
                   ticketSystem.printractickets();
               case 6 :
                   System.out.println("Viewing Waiting List Tickets");
                   ticketSystem.viewWaitingListTickets();
               case 7 :
                   System.out.println("Exiting.....");
                   System.exit(0);
               default:
                   System.out.println("Invalid choice Try again");
           }
       }
    }
}
