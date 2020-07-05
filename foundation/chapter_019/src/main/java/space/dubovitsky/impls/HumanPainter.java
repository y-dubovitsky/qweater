package space.dubovitsky.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import space.dubovitsky.interfaces.Hair;
import space.dubovitsky.interfaces.Head;
import space.dubovitsky.interfaces.Human;
import space.dubovitsky.interfaces.Leg;

public class HumanPainter extends AbstractHuman {

    @Autowired
    private String name;

    public HumanPainter() { //! У бина обязательно должен быть пустой конструктор, так как IOC сперва создает все бины через рефлексию, а затем внедряет зависимости
        System.out.println("Constructor : public HumanPainter()");
    }

    //! Если мы наследуется от класса, где используется автоматическое связывание, мы можем вообще не использовать конструктор с super(hair, head, leg);
    public HumanPainter(Hair hair, Head head, Leg leg) {
        super(hair, head, leg);
    }

    @Override
    public void beHuman() {
        getHair().dye();
        getHead().think();
        getLeg().walk();
        System.out.println(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
