package structural.bridge.client;

import structural.bridge.abstraction.AdvancedRemote;
import structural.bridge.abstraction.BasicRemote;
import structural.bridge.implementation.Device;
import structural.bridge.implementation.Radio;
import structural.bridge.implementation.Tv;

/**
 *
 * @Author: xiaoyl
 * @Date: 2023/07/10/17:07
 * @Description:
 */
public class Demo {
    public static void main(String[] args) {
        testDevice(new Tv());
        testDevice(new Radio());
    }

    public static void testDevice(Device device) {
        System.out.println("Tests with basic remote.");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        device.printStatus();

        System.out.println("Tests with advanced remote.");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.printStatus();
    }

}
