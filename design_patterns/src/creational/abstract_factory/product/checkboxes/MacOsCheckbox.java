package creational.abstract_factory.product.checkboxes;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: xiaoyl
 * @Date: 2023/06/30/14:35
 * @Description:
 */
public class MacOsCheckbox implements Checkbox{
    @Override
    public void paint() {
        System.out.println("You have created MacOSCheckbox.");
    }
}
