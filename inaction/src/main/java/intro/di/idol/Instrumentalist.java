package intro.di.idol;

import intro.di.idol.instruments.Instrument;

public class Instrumentalist implements Performer {

    private Instrument instrument;
    private String song;

    public Instrumentalist() {

    }

    @Override
    public void perform() throws PerformanceException {
        instrument.play();
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public String getSong() {
        return song;
    }
}
