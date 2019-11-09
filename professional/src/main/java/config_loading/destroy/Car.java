package config_loading.destroy;

public class Car {

    private String model;
    private int mileage;

    public Car() {
        System.out.println("Hello from constructor");
    }

    private void destroy() {
        System.out.println("Bean destroyed");
    }

    private void firstInit() {
        System.out.println("private void firstInit() {");
    }

    private void secondInit() {
        System.out.println("private void secondInit() {");
    }
}
