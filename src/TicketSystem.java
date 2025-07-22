import java.util.*;
public class TicketSystem {
    private final ArrayList<String> availableberths= new ArrayList<>(Arrays.asList("L","U","M"));
    private final Queue <passenger> rac= new LinkedList<>();
    private final Queue <passenger> waitinglist= new LinkedList<>();
    private final ArrayList<passenger> confirmedtickets= new ArrayList<>();
    private int ticketcount=1;

    public void bookticket(String name , int age , String gender , String berthpreference ){
        String ticketid = "T"+ticketcount++;
        passenger  passenger ;
        if(!availableberths.isEmpty()){
          String allocateberth = allocateberth(age,gender,berthpreference);
          passenger = new passenger(name , age ,gender,berthpreference,allocateberth,ticketid);
          confirmedtickets.add(passenger);
          availableberths.remove(allocateberth);
          System.out.print("Ticker confirmed "+ passenger);
        }
        else if(rac.size()<1){//-->now we are using only one rac since we only focus on only on L , U , M ---Which has
            //one RAC available in it -
            passenger = new passenger(name , age ,gender,berthpreference,"RAC",ticketid);
            rac.offer(passenger);
            System.out.println("Ticket in waiting in the RAC " + passenger);
        }
        else if(waitinglist.size()<1){//----> if the available ticket and the RAC is filled we will come to the waiting list
            // which has only one waiting list space available in it --
            passenger= new passenger(name , age ,gender,berthpreference,"WAITING LIST",ticketid);
            waitinglist.offer(passenger);
            System.out.println("Ticket in waiting list "+passenger);
        }
        else{//----> no ticket available in any condition of the booking
            System.out.println("No ticket available");
        }
    }
    String  allocateberth(int age , String gender , String preference){
        if(age>60 && gender.equalsIgnoreCase("female")&&availableberths.contains("L")){
            return "L";
        }
        if(availableberths.contains(preference)){
            return  preference;
        }
        return  availableberths.get(0);
    }
    public void cancelticket(String ticketid){
        Optional<passenger> passengeropt = confirmedtickets.stream().filter(p->p.ticketid.equals(ticketid)).findFirst();
        if(passengeropt.isPresent()){
              passenger passenger = passengeropt.get();
              confirmedtickets.remove(passenger);
              availableberths.add(passenger.allotedberth);
              if(!rac.isEmpty()){
                  passenger racpassenger = rac.poll();
                  String allocatedberth=allocateberth(racpassenger.age,racpassenger.gender,racpassenger.berthpreference);
                  racpassenger.allotedberth=allocatedberth;
                  confirmedtickets.add(racpassenger);
                  availableberths.remove(allocatedberth);
              }
              if(!waitinglist.isEmpty()){
                  passenger waitinglistpassenger=waitinglist.poll();
                  waitinglistpassenger.allotedberth="RAC";
                  System.out.println("Waiting list ticket moved to RAC"+waitinglistpassenger);
              }
        }
        else{
            System.out.println("no ticket found with the matching id ");
        }
        System.out.println("Ticket cancelled for the Ticket Id "+ticketid);
    }
    public void printBookedTickets(){
        if(confirmedtickets.isEmpty()){
            System.out.println("No ticket has been Booked till now");
        }
        else{
            System.out.println("Confirmed tickets");
            for( passenger passenger : confirmedtickets){
                System.out.println(passenger);
            }
        }
    }
    public void printAvailableTicket(){
        System.out.println("Available Berths"+availableberths.size());
        System.out.println("Available RAC tickets"+(1- rac.size()));
        System.out.println("Avaiblable Waiting list ticksts"+(1- waitinglist.size()));
    }
    public void printractickets(){
        if(rac.isEmpty()){
            System.out.println("No rac ticket has been booked till now");
        }
        else{
            System.out.println(" RAC tickets");
            for(passenger passenger : rac){
                System.out.println(passenger);
            }
        }
    }
    public void viewWaitingListTickets(){
        if(waitinglist.isEmpty()){
            System.out.println("No ticket is in waiting List");
        }
        else{
            System.out.println("Tickets thats in waiting List");
            for(passenger passenger : waitinglist){
                System.out.println(passenger);
            }
        }
    }

}
