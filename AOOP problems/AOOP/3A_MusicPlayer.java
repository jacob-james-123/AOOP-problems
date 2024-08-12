public class MusicPlayer {
    public static void main(String[] args) {
        musicSource local = new local_files("music file");
        local.play();
        local.pause();
        local.stop();
        musicSource localwithEqualiser = new equaliserDecorator(local);
        localwithEqualiser.play();
        musicSource localwithVolume = new volumeDecorator(local);
        localwithVolume.play();;
    }
}

interface musicSource{
    void play();
    void pause();
    void stop();
}

//local files
class local_files implements musicSource{
    private String fileName;

    local_files(String fileName){
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
class radio implements musicSource{
    String radioname;
    radio(String r){
        this.radioname = r;
    }

    public void play(){
        System.out.println("play local radio "+radioname);
    }

    public void pause(){
        System.out.println("pause radio "+radioname);
    }

    public void stop(){
        System.out.println("stop radio "+radioname);
    }

}

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
