package structural.flyweight.flyweight;

import java.awt.*;

/**
 * 包含多棵树共享的状态
 *
 * @Author: xiaoyl
 * @Date: 2023/07/12/21:39
 * @Description: 享元/缓存
 */
public class TreeType {

    /**
     * 名称
     */
    private final String name;
    /**
     * 颜色
     */
    private final Color color;
    /**
     * 其他内部状态数据
     */
    private final String otherTreeData;

    public TreeType(String name, Color color, String otherTreeData) {
        this.name = name;
        this.color = color;
        this.otherTreeData = otherTreeData;
    }


    /**
     * 原始对象的行为会保留在享元类中
     * @param g 原始对象的外部状态数据
     * @param x 原始对象的外部状态数据
     * @param y 原始对象的外部状态数据
     */
    public void draw(Graphics g, int x, int y) {
        g.setColor(Color.BLACK);
        g.fillRect(x - 1, y, 3, 5);
        g.setColor(color);
        g.fillOval(x - 5, y - 10, 10, 10);
    }


}
