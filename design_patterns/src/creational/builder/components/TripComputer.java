package creational.builder.components;

import creational.builder.product.Car;

/**
 * @Author: xiaoyl
 * @Date: 2023/07/03/15:08
 * @Description: 汽车该产品的特征之一：行车电脑
 */
public class TripComputer {

    private Car car;

    public void setCar(Car car) {
        this.car = car;
    }

    public void showFuelLevel() {
        System.out.println("Fuel level: " + car.getFuel());
    }

    public void showStatus() {
        if (this.car.getEngine().isStarted()) {
            System.out.println("Car is started");
        } else {
            System.out.println("Car isn't started");
        }
    }
}