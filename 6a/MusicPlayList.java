import java.util.LinkedList;

class MusicPlaylist {
    private LinkedList<String> playlist;

    public MusicPlaylist() {
        playlist = new LinkedList<>();
    }

    public void addSong(String song) {
        playlist.add(song);
        System.out.println("Added song: " + song);
    }

    public void removeSong(String song) {
        if (playlist.remove(song)) {
            System.out.println("Removed song: " + song);
        } else {
            System.out.println("Song not found: " + song);
        }
    }

    public void moveSong(int fromIndex, int toIndex) {
        if (fromIndex >= 0 && fromIndex < playlist.size() && toIndex >= 0 && toIndex < playlist.size()) {
            String song = playlist.remove(fromIndex);
            playlist.add(toIndex, song);
            System.out.println("Moved song to position " + (toIndex + 1));
        } else {
            System.out.println("Invalid indices.");
        }
    }

    public void displayPlaylist() {
        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty.");
        } else {
            System.out.println("Playlist:");
            for (int i = 0; i < playlist.size(); i++) {
                System.out.println((i + 1) + ". " + playlist.get(i));
            }
        }
    }

    public static void main(String[] args) {
        MusicPlaylist mp = new MusicPlaylist();
        mp.addSong("Song 1");
        mp.addSong("Song 2");
        mp.addSong("Song 3");
        mp.displayPlaylist();
        mp.moveSong(2, 0);
        mp.displayPlaylist();
        mp.removeSong("Song 1");
        mp.displayPlaylist();
    }
}

