package ioc.inheritance;

public class Boy implements Humanable {

    private String name;
    private int age;
    private String sex;

    @Override
    public String toString() {
        return this.name + " " + this.age + " " + this.sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
