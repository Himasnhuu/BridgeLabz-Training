package music_playlist_manager;
import java.util.*;

public class PlaylistManager {
	
	private LinkedList<Song> playlist = new LinkedList<>();
	private Stack<Song> history = new Stack<>();
	private Set<String> songSet = new HashSet<>();
	
	public void addSong(Song song) throws SongAlreadyExistsException {
		if (songSet.contains(song.getTitle())) {
			throw new SongAlreadyExistsException("Song already exists in the playlist.");
		}
		playlist.add(song);
		songSet.add(song.getTitle());
	}
	
	public void playSong() {
		if(!playlist.isEmpty()) {
			Song song = playlist.removeFirst();
			history.push(song);
			System.out.println("Now playing: " + song);
		}
	}
	
	public void showPlaylist() {
		System.out.println("Current Playlist:");
		playlist.forEach(System.out::println);
	}
	
	public void showRecentlyPlayed() {
		System.out.println("Recently Played Songs:");
		history.forEach(System.out::println);
	}
}
