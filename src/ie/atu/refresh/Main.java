package ie.atu.refresh;

public class Main {
    public static void main(String[] args) {
        // Create 3 Car objects
        Car car1 = new Car("Honda", 2019, true);
        Car car2 = new Car("BMW", 2018, false);
        Car car3 = new Car("Toyota", 2017, true);

        // Print out the details of each car
        System.out.println(car1);
        System.out.println(car2);
        System.out.println(car3);

    }
}
