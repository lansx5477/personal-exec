package creational.builder.components;

/**
 * @Author: xiaoyl
 * @Date: 2023/07/03/15:08
 * @Description: 汽车该产品的特征之一
 */
public class Engine {
    /**
     * 体积
     */
    private final double volume;
    /**
     * 行驶里程
     */
    private double mileage;
    /**
     * 启程
     */
    private boolean started;

    public Engine(double volume, double mileage) {
        this.volume = volume;
        this.mileage = mileage;
    }

    public void on() {
        started = true;
    }

    public void off() {
        started = false;
    }

    public boolean isStarted() {
        return started;
    }

    public void go(double mileage) {
        if (started) {
            this.mileage += mileage;
        } else {
            System.err.println("Cannot go(), you must start engine first!");
        }
    }

    public double getVolume() {
        return volume;
    }

    public double getMileage() {
        return mileage;
    }
}