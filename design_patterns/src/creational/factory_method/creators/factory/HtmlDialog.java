package creational.factory_method.creators.factory;

import creational.factory_method.product.buttons.Button;
import creational.factory_method.product.buttons.HtmlButton;

/**
 *
 * @Author: xiaoyl
 * @Date: 2023/06/30/11:51
 * @Description:
 */
public class HtmlDialog extends Dialog {

    @Override
    Button createButton() {
        return new HtmlButton();
    }
}
