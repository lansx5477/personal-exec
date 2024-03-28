package creational.factory_method.client;

import creational.factory_method.creators.factory.Dialog;
import creational.factory_method.creators.factory.HtmlDialog;
import creational.factory_method.creators.factory.WindowsDialog;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: xiaoyl
 * @Date: 2023/06/30/11:55
 * @Description:
 */
public class Demo {

    private static Dialog dialog;

    public static void main(String[] args) {
        config();
        runBusinessLogic();
    }

    /**
     * 具体工厂的选择通常取决于配置或环境选项
     */
    static void config() {
        if ("Windows 11".equals(System.getProperty("os.name"))) {
            dialog = new WindowsDialog();
        } else {
            dialog = new HtmlDialog();
        }
    }

    /**
     * 所有客户端代码都应该通过抽象接口与工厂和产品一起工作。这样一来，它就不关心与哪家工厂合作，也不关心退回的是哪种产品
     */
    static void runBusinessLogic() {
        dialog.renderWindow();
    }

}
