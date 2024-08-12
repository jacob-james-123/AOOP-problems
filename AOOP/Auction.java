package AOOP;
import java.util.ArrayList;

public class Auction {
    public static void main(String[] args) {
        AuctionPeice item = new AuctionPeice("vintage Sword");
        bider bider1 = new bider("sam");
        bider bider2 = new bider("john");
        //adding observer
        item.addBider(bider1);
        item.addBider(bider2);

        item.SetAuctionState("item is avalibale for bidding "+item.item);
        item.SetAuctionState("bidding has started ");
        //removing observer
        item.removeBidder(bider2);
        item.SetAuctionState("bidding is over ");
    }
}
//obseerver 
interface  observer{
    void updateBider(String AuctionState);
}

//subject interface 
interface subject{
    void addBider(observer o);
    void removeBidder(observer o);
    void notifyBidder();
}

class AuctionPeice implements subject{
    private ArrayList<observer> observer;
    String item;
    String AuctionState;
    AuctionPeice(String item){
        this.item = item;
        observer = new ArrayList<>();
    }

    public void addBider(observer o){
        observer.add(o);
    }

    public void removeBidder(observer o){
        observer.remove(o);
    }

    public void notifyBidder(){
        for(observer o:observer){
            o.updateBider(AuctionState);
        }
    }

    public void SetAuctionState(String AuctionState){
        this.AuctionState = AuctionState ;
        notifyBidder();
    }

    public String getItem(){
        return this.item;
    }
}

class bider implements observer{
    private String bidderName;
    bider(String bidderName){
        this.bidderName  = bidderName;
    }
    public void updateBider(String AuctionState){
        System.out.println("the Notification is for  " +bidderName+ " " + AuctionState);
    }
}
