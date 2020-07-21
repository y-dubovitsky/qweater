package space.dubovitsky.spel.component.impl;

import space.dubovitsky.spel.component.Home;
import space.dubovitsky.spel.component.Window;

public class SweetHome implements Home {

    private Window window;
    private String size;

    public SweetHome() {
    }

    @Override
    public void buildHome() {
        window.openWindow();
        System.out.println(getSize());
    }

    // Getter and Setter

    public Window getWindow() {
        return window;
    }

    public void setWindow(Window window) {
        this.window = window;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
