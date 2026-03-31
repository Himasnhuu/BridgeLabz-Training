package music_playlist_manager;

public class Main {
	public static void main(String[] args) {
		try {
			PlaylistManager manager = new PlaylistManager();
			
			manager.addSong(new Song("Shape of You", "Ed Sheeran"));
			manager.addSong(new Song("Blinding Lights", "The Weeknd"));
			manager.addSong(new Song("Levitating", "Dua Lipa"));
			
			manager.playSong();
			manager.playSong();
			
			manager.showPlaylist();
			manager.showRecentlyPlayed();
		} catch (SongAlreadyExistsException e) {
			System.out.println(e.getMessage());
		}
	}
}
