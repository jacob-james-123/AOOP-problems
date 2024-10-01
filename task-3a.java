package tasks.Task3;

public class t1 {
    
        public static void main(String[] args) {
            // Create a local music source
            MusicSource localMusic = new LocalMusicAdapter(new LocalMusicFile());
    
            // Create an online streaming music source
            MusicSource onlineMusic = new OnlineStreamingAdapter(new OnlineStreamingService());
    
            // Create a radio station music source
            MusicSource radioMusic = new RadioStationAdapter(new RadioStation());
    
            // Play music from local files with volume control and equalizer
            MusicSource enhancedLocalMusic = new EqualizerDecorator(new VolumeControlDecorator(localMusic, 10), "Bass Boost");
            enhancedLocalMusic.playMusic();
    
            System.out.println();
    
            // Play music from online streaming with equalizer
            MusicSource enhancedOnlineMusic = new EqualizerDecorator(onlineMusic, "Classical");
            enhancedOnlineMusic.playMusic();
    
            System.out.println();
    
            // Play radio with volume control
            MusicSource enhancedRadioMusic = new VolumeControlDecorator(radioMusic, 7);
            enhancedRadioMusic.playMusic();
        }
    }
    
    

// Common interface for all music sources
 interface MusicSource {
    void playMusic();
}

// Adapter for Local Music Files
class LocalMusicAdapter implements MusicSource {
    private LocalMusicFile localMusicFile;

    public LocalMusicAdapter(LocalMusicFile localMusicFile) {
        this.localMusicFile = localMusicFile;
    }

    @Override
    public void playMusic() {
        localMusicFile.play();
    }
}

// Adapter for Online Streaming
class OnlineStreamingAdapter implements MusicSource {
    private OnlineStreamingService onlineService;

    public OnlineStreamingAdapter(OnlineStreamingService onlineService) {
        this.onlineService = onlineService;
    }

    @Override
    public void playMusic() {
        onlineService.stream();
    }
}

// Adapter for Radio
class RadioStationAdapter implements MusicSource {
    private RadioStation radioStation;

    public RadioStationAdapter(RadioStation radioStation) {
        this.radioStation = radioStation;
    }

    @Override
    public void playMusic() {
        radioStation.tuneIn();
    }
}

// Local Music File Class
class LocalMusicFile {
    public void play() {
        System.out.println("Playing music from local files...");
    }
}

// Online Streaming Service Class
class OnlineStreamingService {
    public void stream() {
        System.out.println("Streaming music online...");
    }
}

// Radio Station Class
class RadioStation {
    public void tuneIn() {
        System.out.println("Tuning in to radio station...");
    }
}

// Base Decorator class implementing MusicSource
abstract class MusicDecorator implements MusicSource {
    protected MusicSource musicSource;

    public MusicDecorator(MusicSource musicSource) {
        this.musicSource = musicSource;
    }

    @Override
    public void playMusic() {
        musicSource.playMusic();
    }
}

// Volume Control Decorator
class VolumeControlDecorator extends MusicDecorator {
    private int volumeLevel;

    public VolumeControlDecorator(MusicSource musicSource, int volumeLevel) {
        super(musicSource);
        this.volumeLevel = volumeLevel;
    }

    @Override
    public void playMusic() {
        musicSource.playMusic();
        System.out.println("Adjusting volume to level " + volumeLevel);
    }
}

// Equalizer Decorator
class EqualizerDecorator extends MusicDecorator {
    private String preset;

    public EqualizerDecorator(MusicSource musicSource, String preset) {
        super(musicSource);
        this.preset = preset;
    }

    @Override
    public void playMusic() {
        musicSource.playMusic();
        System.out.println("Applying equalizer preset: " + preset);
    }
}
