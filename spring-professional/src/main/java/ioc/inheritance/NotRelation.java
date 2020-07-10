package ioc.inheritance;

/**
 * Этот класс никак не связан с другими классами( Boy, Kid...)
 */
public class NotRelation {

    private String name;
    private int age;
    private String sex;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return this.name + " " + this.age + " " + this.sex;
    }
}
