package structural.bridge.implementation;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: xiaoyl
 * @Date: 2023/07/10/16:29
 * @Description:
 */
public interface Device {

    /**
     * 判断设备的状态是否为开启状态
     * @return
     */
    boolean isEnabled();

    /**
     * 开启设备
     */
    void enable();

    /**
     * 关闭设备
     */
    void disable();

    /**
     * 获取音量
     * @return
     */
    int getVolume();

    /**
     * 设置音量
     * @param percent
     */
    void setVolume(int percent);

    /**
     * 获取频道
     * @return
     */
    int getChannel();

    /**
     * 设置频道
     * @param channel
     */
    void setChannel(int channel);

    /**
     * 显示当前设备状态
     */
    void printStatus();


}
