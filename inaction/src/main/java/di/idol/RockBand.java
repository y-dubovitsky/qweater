package di.idol;

import di.idol.instruments.Instrument;

import java.io.*;
import java.util.Map;

public class RockBand implements Performer {

    private Map<String, Instrument> instrument;

    public RockBand() {
        System.out.println("Hello from constructor " + getClass().getName());
    }

    /**
     * Before all, but constructor first;
     */
    public void beforeAll() {
        try(InputStream in = getClass().getResourceAsStream("config.xml");
        BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            String str = null;
            while ((str = reader.readLine()) != null) {
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void perform() throws PerformanceException {
        for (String key : instrument.keySet()) {
            System.out.println("Key :" + key);
            Instrument instrum = instrument.get(key);
            instrum.play();
        }
    }

    public Map<String, Instrument> getInstrument() {
        return instrument;
    }

    public void setInstrument(Map<String, Instrument> instrument) {
        this.instrument = instrument;
    }
}
