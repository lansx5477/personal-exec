package creational.abstract_factory.product.buttons;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: xiaoyl
 * @Date: 2023/06/30/14:30
 * @Description:
 */
public class MacOsButton implements Button {

    @Override
    public void paint() {
        System.out.println("You have created MacOSButton.");
    }
}
