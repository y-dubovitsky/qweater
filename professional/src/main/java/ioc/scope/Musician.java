package ioc.scope;

import org.springframework.beans.factory.annotation.Value;

/**
 * Simple class which .xml config
 */
public class Musician {

    private String song = "Fly me to the moon";
    private int year = 1905;

    public Musician(String str) {
        this.song = str;
    }

    public Musician(@Value("50 cents") String str, int year) {
        this.song = str;
        this.year = year;
    }

    @Override
    public String toString() {
        return this.song + " " + this.year;
    }
}
