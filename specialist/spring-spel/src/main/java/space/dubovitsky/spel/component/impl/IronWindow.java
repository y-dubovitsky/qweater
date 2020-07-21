package space.dubovitsky.spel.component.impl;

import space.dubovitsky.spel.component.Window;

public class IronWindow implements Window {
    @Override
    public void openWindow() {
        System.out.println("Hello, this is a Iron Window");
    }
}
