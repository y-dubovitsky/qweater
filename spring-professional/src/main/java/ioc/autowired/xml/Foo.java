package ioc.autowired.xml;

public class Foo {

    private String name;

    public Foo(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
