package intro.di.idol;

import intro.di.idol.instruments.Instrument;

public class CarlInstrumentalist implements Performer {

    private String song;
    private Instrument instrument;

    @Override
    public void perform() throws PerformanceException {
        instrument.play();
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }
}
