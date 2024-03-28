package structural.composite.component;

import java.awt.*;

/**
 * 组合的叶节点
 * @author 28417
 */
public class Circle extends BaseShape {
    public int radius;

    public Circle(int x, int y, int radius, Color color) {
        super(x, y, color);
        this.radius = radius;
    }

    public Circle(Circle circle) {
        super(circle);
        if (circle != null) {
            this.radius = circle.getRadius();
        }
    }

    @Override
    public int getWidth() {
        return radius * 2;
    }

    @Override
    public int getHeight() {
        return radius * 2;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public Boolean getSelected() {
        return super.getSelected();
    }

    public void paint(Graphics graphics) {
        super.paint(graphics);
        graphics.drawOval(x, y, getWidth() - 1, getHeight() - 1);
    }

    /**
     * 克隆方法
     * @return
     */
    @Override
    public Shape clone() {
        return new Circle(this);
    }


    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", x=" + x +
                ", y=" + y +
                ", color=" + color +
                ", selected=" + super.getSelected() +
                '}';
    }
}