package structural.bridge.abstraction;

/**
 *
 * @Author: xiaoyl
 * @Date: 2023/07/10/16:41
 * @Description: 抽象部分的通用接口，提供高层控制逻辑，依赖于完成底层实际工作的实现对象
 */
public interface Remote {

    void power();

    void volumeDown();

    void volumeUp();

    void channelDown();

    void channelUp();

}
