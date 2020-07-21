package space.dubovitsky.spel.component.factory;

import space.dubovitsky.spel.component.Window;
import space.dubovitsky.spel.component.impl.IronWindow;
import space.dubovitsky.spel.component.impl.WoodenWindow;

/**
 * Factory of windows.
 */
public class WindowFactory {

    public static Window getWindow(String type) {
        if (type.equals("WoodenWindow")) {
            return new WoodenWindow();
        }
        return new IronWindow();
    }

}
