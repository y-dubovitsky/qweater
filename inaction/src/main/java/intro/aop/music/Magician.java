package intro.aop.music;

/**
 * This is aspect
 */
public class Magician implements MindReader {

    private String thoughts;

    /**
     * Setter
     * @param thoughts
     */
    @Override
    public void interceptThoughts(String thoughts) {
        System.out.println("Intercepting volunteer’s thoughts");
        this.thoughts = thoughts;
    }

    @Override
    public String getThoughts() {
        return null;
    }
}
