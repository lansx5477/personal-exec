package creational.factory_method.product.buttons;

/**
 *
 *
 * @Author: xiaoyl
 * @Date: 2023/06/30/11:41
 * @Description: 所有按钮的通用接口
 */
public interface Button {
    /**
     * 渲染
     */
    void render();

    /**
     * 点击
     */
    void onClick();
}
