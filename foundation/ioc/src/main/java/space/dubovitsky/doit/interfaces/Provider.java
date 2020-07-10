package space.dubovitsky.doit.interfaces;

public interface Provider {

    void setMessage(Message message); //! Этот класс зависит от другого класса

    void action();

}
