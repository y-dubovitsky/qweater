package di.idol;

/**
 * Singleton class
 */
public class Stage {

    private Stage(){
    }

    private static class SingletonStage {
        static Stage instance = new Stage();
    }

    public static Stage getInstance() {
        return SingletonStage.instance;
    }
}
