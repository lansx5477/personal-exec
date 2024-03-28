package creational.factory_method.product.buttons;

/**
 *
 * @Author: xiaoyl
 * @Date: 2023/06/30/11:42
 * @Description: 具体的按钮
 */
public class HtmlButton implements Button {

    @Override
    public void render() {
        System.out.println("<button>Test Button</button>");
        onClick();
    }

    @Override
    public void onClick() {
        System.out.println("Click! Button says - 'Hello World!'");
    }
}
