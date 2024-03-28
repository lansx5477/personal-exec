package creational.abstract_factory.client;

import creational.abstract_factory.app.Application;
import creational.abstract_factory.creators.GuiFactory;
import creational.abstract_factory.creators.MacOsFactory;
import creational.abstract_factory.creators.WindowsFactory;

/**
 *
 * @Author: xiaoyl
 * @Date: 2023/06/30/14:26
 * @Description: 跨平台 GUI 组件系列及其创建方式
 *
 * 在本例中， 按钮和复选框将被作为产品。 它们有两个变体： macOS 版和 Windows 版。
 *
 * 抽象工厂定义了用于创建按钮和复选框的接口。 而两个具体工厂都会返回同一变体的两个产品。
 *
 * 客户端代码使用抽象接口与工厂和产品进行交互。 同样的代码能与依赖于不同工厂对象类型的多种产品变体进行交互。
 */
public class Demo {

    public static void main(String[] args) {
        Application app = configureApplication();
        app.paint();
    }

    private static Application configureApplication() {
        Application app;
        GuiFactory factory;

        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("mac")) {
            factory = new MacOsFactory();
        } else {
            factory = new WindowsFactory();
        }
        app = new Application(factory);
        return app;
    }

}
