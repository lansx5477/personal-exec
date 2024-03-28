package creational.abstract_factory.creators;

import creational.abstract_factory.product.buttons.Button;
import creational.abstract_factory.product.buttons.WindowsButton;
import creational.abstract_factory.product.checkboxes.Checkbox;
import creational.abstract_factory.product.checkboxes.WindowsCheckbox;

/**
 *
 * @Author: xiaoyl
 * @Date: 2023/06/30/14:39
 * @Description:
 */
public class WindowsFactory implements GuiFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
