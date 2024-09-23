package ie.atu.refresh;

public class Car {

    // Instance variables
    private String make;
    private int year;
    private boolean isSold;

    // Constructor
    public Car(String make, int year, boolean isSold) {
        this.make = make;
        this.year = year;
        this.isSold = isSold;
    }

    // Getters and Setters
    public String getMake() {
        return make;
    } 

    public void setMake(String make) {
        this.make = make;
    } 

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isSold() {
        return isSold;
    }

    public void setSold(boolean isSold) {
        this.isSold = isSold;
    }

    // toString method
    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", year=" + year +
                ", isSold=" + isSold +
                '}';
    }

}
