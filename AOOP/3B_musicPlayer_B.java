public class musicPlayer_B{
    public static void main(String[] args) {
        //adapter 
        musicSource onlineplayer = new OnlinemusicAdapter("the nights-> is being form online ");
        //decorator
        musicSource equaliser = new equaliserDecorator(onlineplayer);
        equaliser.play();
        equaliser.pause();
        //adapter 
        musicSource radio = new radioStationAdapter("fm radiois playing ");
         //decorator
        musicSource volume= new volumeDecorator(radio);
        volume.play();
        volume.pause();
        //bridge 
        MusicPlayer advancedPlayer = new AdavancedMusicPlayer(radio);
        advancedPlayer.play();
        advancedPlayer.stop();

    }
}

// this interface for music source

interface musicSource{
    void play();
    void pause();
    void stop();
}

//local files
class OnlinemusicAdapter implements musicSource{
    private String fileName;

    OnlinemusicAdapter(String fileName){
        this.fileName = fileName;
    }

    public void play(){
        System.out.println("play local file "+fileName);
    }

    public void pause(){
        System.out.println("pause local file "+fileName);
    }

    public void stop(){
        System.out.println("stop local file "+fileName);
    }
}

//radio files
class radioStationAdapter implements musicSource{
    String radioname;
    radioStationAdapter(String r){
        this.radioname = r;
    }

    public void play(){
        System.out.println("play  radio "+ radioname);
    }

    public void pause(){
        System.out.println("pause radio "+ radioname);
    }

    public void stop(){
        System.out.println("stop radio "+radioname);
    }

}

// decorator pattern to add additonal features for music
 abstract class musicDecorator implements musicSource{
    private musicSource ms;
    musicDecorator(musicSource ms){
        this.ms = ms;
    }

    public void play(){
        ms.play();
    }

    public void pause(){
        ms.pause();
    }

    public void stop(){
        ms.stop();
    }
}

// equaliser feature add
class equaliserDecorator extends musicDecorator{
    equaliserDecorator(musicSource ms){
        super(ms);
    }

    public void play(){
        super.play();
        eqaliser();
    }
    private void eqaliser(){
        System.out.println("equaliser is on");
    }
}

//volume feature added
class volumeDecorator extends musicDecorator{
    volumeDecorator(musicSource ms){
        super(ms);
    }

    public void play(){
        super.play();
        volume();
    }

    private void volume(){
        System.out.println("volume is on ");

    }
}

// bridge pattern
abstract class MusicPlayer{
     musicSource ms;

    MusicPlayer(musicSource ms){
        this.ms = ms;
    }

    abstract void play();
    abstract void stop();
    abstract void pause();
}
//decoupling the music source and advanced media player so the changes in one don't effect the other
class AdavancedMusicPlayer extends MusicPlayer{
    AdavancedMusicPlayer(musicSource ms){
        super(ms);
        System.out.println("adavanced media player is mode is on now ");
    }

    void play(){
        ms.play();
    }

    void pause(){
        ms.pause();
    }
    void stop(){
        ms.stop();
    }

}