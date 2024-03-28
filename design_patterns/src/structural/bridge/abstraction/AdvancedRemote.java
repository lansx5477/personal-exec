package structural.bridge.abstraction;

import structural.bridge.implementation.Device;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: xiaoyl
 * @Date: 2023/07/10/17:04
 * @Description:
 */
public class AdvancedRemote extends BasicRemote {

    public AdvancedRemote(Device device) {
        super.device = device;
    }


    public void mute() {
        System.out.println("Remote: mute");
        device.setVolume(0);
    }

}
