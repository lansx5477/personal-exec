package creational.builder.builders;

import creational.builder.components.*;

/**
 *
 * @Author: xiaoyl
 * @Date: 2023/07/03/15:05
 * @Description: Builder接口定义了构造产品的所有可能的步骤的方法。
 */
public interface Builder {
    /**
     * 设置生成器生成的汽车的汽车类型
     * @param type
     */
    void setCarType(CarType type);

    /**
     * 设置生成器生成的汽车的座位信息
     * @param seats
     */
    void setSeats(int seats);

    /**
     * 设置生成器生成的汽车的引擎
     * @param engine
     */
    void setEngine(Engine engine);

    /**
     * 设置生成器生成的汽车的变速器
     * @param transmission
     */
    void setTransmission(Transmission transmission);

    /**
     * 设置生成器生成的汽车的行车电脑
     * @param tripComputer
     */
    void setTripComputer(TripComputer tripComputer);

    /**
     * 设置生成器生成的汽车的GPS导航
     * @param gpsNavigator
     */
    void setGPSNavigator(GPSNavigator gpsNavigator);

}
