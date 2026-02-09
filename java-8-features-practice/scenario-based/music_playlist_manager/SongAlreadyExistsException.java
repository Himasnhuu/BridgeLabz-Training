package music_playlist_manager;

@SuppressWarnings("serial")
class SongAlreadyExistsException extends Exception {
    public SongAlreadyExistsException(String message) {
        super(message);
    }
}
