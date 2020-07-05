package space.dubovitsky.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import space.dubovitsky.abstr.AbstractHuman;
import space.dubovitsky.interfaces.Hair;
import space.dubovitsky.interfaces.Head;
import space.dubovitsky.interfaces.Leg;

@Component
public class HumanPainter extends AbstractHuman {

    @Autowired(required = false)
    private String name;

    public HumanPainter() { //! У бина обязательно должен быть пустой конструктор, так как IOC сперва создает все бины через рефлексию, а затем внедряет зависимости
        System.out.println("Constructor : public HumanPainter()");
    }

    public HumanPainter(String name) {
        this.name = name;
    }

    //! Если мы наследуется от класса, где используется автоматическое связывание, мы можем вообще не использовать конструктор с super(hair, head, leg);
    public HumanPainter(Hair hair, Head head, Leg leg) {
        super(hair, head, leg);
    }

    @Bean //! Спринг автоматически просканировал пакеты и создал этот Бин, объявленный в другом Бине
    @Scope(value = "prototype")
    public HumanPainter createHumanPainter() {
        return new HumanPainter("My name is Slim Shady");
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
