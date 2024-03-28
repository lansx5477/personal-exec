package structural.facade.facedes;

/**
 * 视频转化器外观的单例工厂类
 * @Author: xiaoyl
 * @Date: 2023/07/12/0:29
 * @Description:
 */
public class SingleFacadeFactory {

    private volatile static VideoConversionFacade facade;

    private SingleFacadeFactory() {
    }

    public static VideoConversionFacade getVideoConversionFacade() {
        if (facade == null) {
            synchronized (SingleFacadeFactory.class) {
                if (facade == null) {
                    facade = new VideoConversionFacade();
                }
                return facade;
            }
        }
        return facade;
    }

}
