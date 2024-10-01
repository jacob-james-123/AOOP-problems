package tasks.Task3;

public class t2 {
    
        public static void main(String[] args) {
            // Choose a music source (local file, online streaming, or radio)
            MusicSource localMusicSource = new LocalMusicAdapter(new LocalMusicFile());
            MusicSource onlineMusicSource = new OnlineStreamingAdapter(new OnlineStreamingService());
            MusicSource radioMusicSource = new RadioStationAdapter(new RadioStation());
    
            // Basic music player for local files
            MusicPlayer basicPlayer = new BasicMusicPlayer(localMusicSource);
            basicPlayer.play();
    
            System.out.println();
    
            // Advanced music player for online streaming with volume control and equalizer
            MusicPlayer advancedPlayer = new AdvancedMusicPlayer(onlineMusicSource);
            MusicPlayer advancedPlayerWithFeatures = new VolumeControlDecorator(new EqualizerDecorator(advancedPlayer, "Pop"), 8);
            advancedPlayerWithFeatures.play();
    
            System.out.println();
    
            // Radio playback with volume control
            MusicPlayer radioPlayer = new AdvancedMusicPlayer(radioMusicSource);
            MusicPlayer radioPlayerWithVolume = new VolumeControlDecorator(radioPlayer, 5);
            radioPlayerWithVolume.play();
        }
    }
    


// Common interface for all music sources
 interface MusicSource {
    void load();
}

// Adapter for Local Music Files
class LocalMusicAdapter implements MusicSource {
    private LocalMusicFile localMusicFile;

    public LocalMusicAdapter(LocalMusicFile localMusicFile) {
        this.localMusicFile = localMusicFile;
    }

    @Override
    public void load() {
        localMusicFile.loadMusic();
    }
}

// Adapter for Online Streaming
class OnlineStreamingAdapter implements MusicSource {
    private OnlineStreamingService onlineStreamingService;

    public OnlineStreamingAdapter(OnlineStreamingService onlineStreamingService) {
        this.onlineStreamingService = onlineStreamingService;
    }

    @Override
    public void load() {
        onlineStreamingService.connectAndStream();
    }
}

// Adapter for Radio
class RadioStationAdapter implements MusicSource {
    private RadioStation radioStation;

    public RadioStationAdapter(RadioStation radioStation) {
        this.radioStation = radioStation;
    }

    @Override
    public void load() {
        radioStation.tuneRadio();
    }
}

class LocalMusicFile {
    public void loadMusic() {
        System.out.println("Loading music from local files...");
    }
}

class OnlineStreamingService {
    public void connectAndStream() {
        System.out.println("Connecting and streaming music online...");
    }
}

class RadioStation {
    public void tuneRadio() {
        System.out.println("Tuning into radio station...");
    }
}

// Music Player abstraction
abstract class MusicPlayer {
    protected MusicSource musicSource;

    public MusicPlayer(MusicSource musicSource) {
        this.musicSource = musicSource;
    }

    public abstract void play();
}

// Concrete player that can play basic music
class BasicMusicPlayer extends MusicPlayer {

    public BasicMusicPlayer(MusicSource musicSource) {
        super(musicSource);
    }

    @Override
    public void play() {
        musicSource.load();
        System.out.println("Playing music using Basic Music Player...");
    }
}

// Concrete player with advanced features
class AdvancedMusicPlayer extends MusicPlayer {

    public AdvancedMusicPlayer(MusicSource musicSource) {
        super(musicSource);
    }

    @Override
    public void play() {
        musicSource.load();
        System.out.println("Playing music using Advanced Music Player...");
    }
}

// Base Decorator class implementing MusicPlayer
abstract class MusicPlayerDecorator extends MusicPlayer {
    protected MusicPlayer decoratedPlayer;

    public MusicPlayerDecorator(MusicPlayer musicPlayer) {
        super(musicPlayer.musicSource);
        this.decoratedPlayer = musicPlayer;
    }

    @Override
    public void play() {
        decoratedPlayer.play();
    }
}

// Volume Control Decorator
class VolumeControlDecorator extends MusicPlayerDecorator {
    private int volumeLevel;

    public VolumeControlDecorator(MusicPlayer musicPlayer, int volumeLevel) {
        super(musicPlayer);
        this.volumeLevel = volumeLevel;
    }

    @Override
    public void play() {
        super.play();
        System.out.println("Setting volume to level: " + volumeLevel);
    }
}

// Equalizer Decorator
class EqualizerDecorator extends MusicPlayerDecorator {
    private String equalizerPreset;

    public EqualizerDecorator(MusicPlayer musicPlayer, String equalizerPreset) {
        super(musicPlayer);
        this.equalizerPreset = equalizerPreset;
    }

    @Override
    public void play() {
        super.play();
        System.out.println("Applying equalizer preset: " + equalizerPreset);
    }
}
