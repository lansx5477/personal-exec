package creational.factory_method.creators.factory;

import creational.factory_method.product.buttons.Button;

/**
 *
 * @Author: xiaoyl
 * @Date: 2023/06/30/11:47
 * @Description: 文本框
 */
public abstract class Dialog {

    public void renderWindow() {
        // ... other code ...

        Button okButton = createButton();
        okButton.render();
    }


    /**
     * 创建按钮的抽象方法，由子类实现，创建特定的按钮对象
     * @return
     */
    abstract Button createButton();

}
