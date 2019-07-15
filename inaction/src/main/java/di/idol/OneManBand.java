package di.idol;

import di.idol.instruments.Instrument;

import java.util.Collection;

public class OneManBand implements Performer {

    private Collection<Instrument> instrument;

    /**
     * This method init before after generate object of this class;
     * @return
     */
    private void beforePerform() {
        System.out.println(this.getClass().getCanonicalName());
    }

    public OneManBand() {

    }

    @Override
    public void perform() throws PerformanceException {
        for (Instrument i : instrument) {
            i.play();
        }
    }

    public Collection<Instrument> getInstrument() {
        return instrument;
    }

    public void setInstrument(Collection<Instrument> instrument) {
        this.instrument = instrument;
    }
}
