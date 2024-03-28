package structural.composite.component;

import java.awt.*;

/**
 * @Author: xiaoyl
 * @Date: 2023/07/11/10:57
 * @Description: 叶节点
 */
public class Dot extends BaseShape {

    private final int DOT_SIZE = 3;

    public Dot(int x, int y, Color color) {
        super(x, y, color);
    }

    public Dot(Dot dot) {
        super(dot);
    }

    @Override
    public int getWidth() {
        return DOT_SIZE;
    }

    @Override
    public int getHeight() {
        return DOT_SIZE;
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        graphics.fillRect(x - 1, y - 1, getWidth(), getHeight());
    }

    @Override
    public Shape clone() {
        return new Dot(this);
    }

    @Override
    public String toString() {
        return "Dot{" +
                "DOT_SIZE=" + DOT_SIZE +
                ", x=" + x +
                ", y=" + y +
                ", color=" + color +
                ", selected=" + super.getSelected() +
                '}';
    }
}
