package creational.abstract_factory.creators;

import creational.abstract_factory.product.buttons.Button;
import creational.abstract_factory.product.checkboxes.Checkbox;

/**
 *
 * @Author: xiaoyl
 * @Date: 2023/06/30/14:37
 * @Description:
 */
public interface GuiFactory {
    /**
     * createButton
     * @return
     */
    Button createButton();

    /**
     * createCheckbox
     * @return
     */
    Checkbox createCheckbox();
}
