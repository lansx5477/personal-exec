package creational.builder.client;

import creational.builder.builders.CarBuilder;
import creational.builder.builders.CarManualBuilder;
import creational.builder.director.Director;
import creational.builder.product.Car;
import creational.builder.product.Manual;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: xiaoyl
 * @Date: 2023/07/03/15:50
 * @Description:
 */
public class Demo {

    public static void main(String[] args) {

        Director director = new Director();
        /**
         * Director从客户端(应用程序代码)获取具体的构建器对象。这是因为应用程序更清楚使用哪个构建器来获得特定的产品。
         */
        CarBuilder builder = new CarBuilder();
        director.constructSportsCar(builder);

        /**
         * 最终产品通常从构建器对象中获取，因为Director不知道也不依赖于具体的构建器和产品。
         */
        Car car = builder.getResult();
        System.out.println("Car built:\n" + car.getCarType());

        CarManualBuilder manualBuilder = new CarManualBuilder();
        director.constructSportsCar(manualBuilder);
        Manual carManual = manualBuilder.getResult();
        System.out.println("\nCar manual built:\n" + carManual.print());

    }

}
