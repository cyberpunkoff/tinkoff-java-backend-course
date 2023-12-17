package edu.hw10.task1;

public class Car {
    @Min(200)
    int speed;
    int weight;
    String mark;

    public Car() {}

    public static Car build() {
        Car car = new Car();
        car.mark = "soni";
        return car;
    }
}
