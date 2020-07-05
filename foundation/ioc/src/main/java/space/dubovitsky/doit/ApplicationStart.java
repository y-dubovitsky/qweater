package space.dubovitsky.doit;

import space.dubovitsky.doit.factory.FactoryBean;
import space.dubovitsky.doit.interfaces.Provider;

public class ApplicationStart {

    public static void main(String[] args) {
        Provider provider = FactoryBean.getProvider(); //! Почти спринг, FactoryBean - содержит 'контекст' с бинами
        provider.action();
    }
}
