package tasks.Task5.t2;

// MessageService interface
interface MessageService {
    void sendMessage(String message, String recipient);
}

// EmailService implementing MessageService
class EmailService implements MessageService {
    @Override
    public void sendMessage(String message, String recipient) {
        System.out.println("Email sent to " + recipient + " with message: " + message);
    }
}

// SMSService implementing MessageService
class SMSService implements MessageService {
    @Override
    public void sendMessage(String message, String recipient) {
        System.out.println("SMS sent to " + recipient + " with message: " + message);
    }
}

// MyApplication class depending on MessageService abstraction
class MyApplication {
    private MessageService messageService;

    // Constructor injection for dependency inversion
    public MyApplication(MessageService messageService) {
        this.messageService = messageService;
    }

    public void processMessage(String message, String recipient) {
        messageService.sendMessage(message, recipient);
    }
}

// Main class to demonstrate Dependency Inversion Principle
public class DIPDemo {
    public static void main(String[] args) {
        // Using EmailService
        MessageService emailService = new EmailService();
        MyApplication app1 = new MyApplication(emailService);
        app1.processMessage("Hello, John!", "john@example.com");

        // Using SMSService
        MessageService smsService = new SMSService();
        MyApplication app2 = new MyApplication(smsService);
        app2.processMessage("Hi, Alice!", "alice123");
    }
}

