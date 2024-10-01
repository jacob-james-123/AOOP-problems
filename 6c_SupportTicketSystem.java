package tasks.task6.t1;

import java.util.LinkedList;
import java.util.Queue;

public class SupportTicketSystem {
    private Queue<String> ticketQueue;

    public SupportTicketSystem() {
        ticketQueue = new LinkedList<>();
    }

    // Add a new ticket to the queue
    public void addTicket(String ticket) {
        ticketQueue.add(ticket);
    }

    // Process (remove) the next ticket in line
    public void processNextTicket() {
        if (!ticketQueue.isEmpty()) {
            System.out.println("Processing ticket: " + ticketQueue.poll());
        } else {
            System.out.println("No tickets to process.");
        }
    }

    // Display all pending tickets
    public void displayPendingTickets() {
        System.out.println("Pending tickets: " + ticketQueue);
    }

    public static void main(String[] args) {
        SupportTicketSystem sts = new SupportTicketSystem();
        sts.addTicket("Ticket 1: Unable to log in.");
        sts.addTicket("Ticket 2: Website is slow.");
        sts.displayPendingTickets();
        sts.processNextTicket();
        sts.displayPendingTickets();
    }
}
