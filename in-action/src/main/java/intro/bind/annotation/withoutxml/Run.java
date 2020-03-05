package intro.bind.annotation.withoutxml;

public class Run implements Perform {

    private String name;
    private int lenght;

    public Run() {
    }

    public Run(String name) {
        this.name = name;
    }

    public Run(String name, int lenght) {
        this(name);
        this.lenght = lenght;
    }

    @Override
    public void doAction() {
        System.out.println("And now our sportsmen " + name + " running : " + lenght);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }
}
