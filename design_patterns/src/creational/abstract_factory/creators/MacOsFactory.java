package creational.abstract_factory.creators;

import creational.abstract_factory.product.buttons.Button;
import creational.abstract_factory.product.buttons.MacOsButton;
import creational.abstract_factory.product.checkboxes.Checkbox;
import creational.abstract_factory.product.checkboxes.MacOsCheckbox;

/**
 *
 * @Author: xiaoyl
 * @Date: 2023/06/30/14:38
 * @Description:
 */
public class MacOsFactory implements GuiFactory{
    @Override
    public Button createButton() {
        return new MacOsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOsCheckbox();
    }
}
