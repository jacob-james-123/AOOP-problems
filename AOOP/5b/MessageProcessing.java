public class MessageProcessing {
    public static void main(String[] args) {
        
        MessageService email = new EmailService();
        MessageService sms = new SMSService();
        
        MyApplication emailAPP = new MyApplication(email);
        emailAPP.sendMessage("jacob", "KLH");
        MyApplication smsAPP = new MyApplication(sms);
        smsAPP.sendMessage("alex", "KLH");
    }
}
// Dependency inversion principle 
interface MessageService {
    void sendMessage(String message, String recipient);
}
//depedent on interface MessageService
class EmailService implements MessageService {
    @Override
    public void sendMessage(String message, String recipient) {
        System.out.println("Email sent to " + recipient + " with message: " + message);
    }
}
//depedent on interface MessageService
class SMSService implements MessageService {
    @Override
    public void sendMessage(String message, String recipient) {
        System.out.println("SMS sent to " + recipient + " with message: " + message);
    }
}

 class MyApplication{
    MessageService ms;

    MyApplication(MessageService ms){
        this.ms = ms;
    }

    public void sendMessage(String message,String recipient){
        this.ms.sendMessage(message, recipient);
    }
}