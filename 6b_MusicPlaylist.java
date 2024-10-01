package tasks.task6.t1;
import java.util.LinkedList;

public class MusicPlaylist {
    private LinkedList<String> playlist;

    public MusicPlaylist() {
        playlist = new LinkedList<>();
    }

    // Add a song to the playlist
    public void addSong(String song) {
        playlist.add(song);
        System.out.println("Added: " + song);
    }

    // Remove a song by name
    public void removeSong(String song) {
        if (playlist.remove(song)) {
            System.out.println("Removed: " + song);
        } else {
            System.out.println("Song not found.");
        }
    }

    // Move a song to a different position
    public void moveSong(int fromIndex, int toIndex) {
        if (fromIndex >= 0 && fromIndex < playlist.size() && toIndex >= 0 && toIndex < playlist.size()) {
            String song = playlist.remove(fromIndex);
            playlist.add(toIndex, song);
            System.out.println("Moved: " + song + " to position " + (toIndex + 1));
        } else {
            System.out.println("Invalid index.");
        }
    }

    // Display the playlist
    public void displayPlaylist() {
        System.out.println("Playlist:");
        for (int i = 0; i < playlist.size(); i++) {
            System.out.println((i + 1) + ". " + playlist.get(i));
        }
    }

    public static void main(String[] args) {
        MusicPlaylist playlist = new MusicPlaylist();
        playlist.addSong("Song 1");
        playlist.addSong("Song 2");
        playlist.addSong("Song 3");
        playlist.displayPlaylist();
        playlist.moveSong(2, 0);
        playlist.removeSong("Song 1");
        playlist.displayPlaylist();
    }
}
