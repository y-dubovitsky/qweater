package aop.music;

/**
 * This is tha volunteer, who s mind magician will be read
 */
public class Volunteer implements Thinker{

    private String thoughts;

    /**
     * Just simple setter
     * @param thoughts
     */
    public void thinkOfSomething(String thoughts) {
        this.thoughts = thoughts;
    }

    public String getThoughts() {
        return thoughts;
    }
}

