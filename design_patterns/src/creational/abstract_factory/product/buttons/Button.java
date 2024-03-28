package creational.abstract_factory.product.buttons;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: xiaoyl
 * @Date: 2023/06/30/14:29
 * @Description: 抽象工厂假设你有几个产品族，构成单独的类层次结构(按钮/复选框)。同一家族的所有产品都有共同的接口。这是按钮家族的通用接口。
 */
public interface Button {
    /**
     * paint
     */
    void paint();
}
