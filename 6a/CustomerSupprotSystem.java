import java.util.LinkedList;
import java.util.Queue;

class CustomerSupportSystem {
    private Queue<String> tickets;

    public CustomerSupportSystem() {
        tickets = new LinkedList<>();
    }

    public void addTicket(String ticket) {
        tickets.add(ticket);
        System.out.println("Ticket added: " + ticket);
    }

    public void processNextTicket() {
        if (!tickets.isEmpty()) {
            System.out.println("Processing ticket: " + tickets.poll());
        } else {
            System.out.println("No tickets to process.");
        }
    }

    public void displayPendingTickets() {
        if (tickets.isEmpty()) {
            System.out.println("No pending tickets.");
        } else {
            System.out.println("Pending Tickets:");
            for (String ticket : tickets) {
                System.out.println(ticket);
            }
        }
    }

    public static void main(String[] args) {
        CustomerSupportSystem css = new CustomerSupportSystem();
        css.addTicket("Ticket 1");
        css.addTicket("Ticket 2");
        css.displayPendingTickets();
        css.processNextTicket();
        css.displayPendingTickets();
    }
}
