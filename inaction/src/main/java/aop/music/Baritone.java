package aop.music;

public class Baritone implements Musician {

    private Song song;

    @Override
    public void play() {
        song.sing();
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }
}
