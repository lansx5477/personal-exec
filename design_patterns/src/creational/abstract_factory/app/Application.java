package creational.abstract_factory.app;

import creational.abstract_factory.creators.GuiFactory;
import creational.abstract_factory.product.checkboxes.Checkbox;
import creational.abstract_factory.product.buttons.Button;

/**
 *
 * @Author: xiaoyl
 * @Date: 2023/06/30/14:40
 * @Description:
 */
public class Application {

    private Button button;

    private Checkbox checkbox;

    public Application(GuiFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void paint() {
        button.paint();
        checkbox.paint();
    }
}
