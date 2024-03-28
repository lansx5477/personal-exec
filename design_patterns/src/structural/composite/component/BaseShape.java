package structural.composite.component;

import java.awt.*;

/**
 * @Author: xiaoyl
 * @Date: 2023/07/11/10:50
 * @Description: 提供基本功能的抽象shape
 */
public abstract class BaseShape implements Shape {

    public int x;
    public int y;

    public Color color;
    private boolean selected = false;

    BaseShape(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }


    BaseShape(BaseShape shape) {
        this.x = shape.getX();
        this.y = shape.getY();
        this.color = shape.getColor();
        this.selected = shape.getSelected();
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public Boolean getSelected() {
        return selected;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public void move(int x, int y) {
        this.x = this.x + x;
        this.y = this.y + y;
    }

    @Override
    public boolean isInsideBounds(int x, int y) {
        return x > getX() && x < (getX() + getWidth()) &&
                y > getY() && y < (getY() + getHeight());
    }

    @Override
    public void select() {
        selected = true;
    }

    @Override
    public void unSelect() {
        selected = false;
    }

    @Override
    public boolean isSelected() {
        return selected;
    }

    void enableSelectionStyle(Graphics graphics) {
        graphics.setColor(Color.LIGHT_GRAY);
        Graphics2D g2 = (Graphics2D) graphics;
        float[] dash1 = {2.0f};
        g2.setStroke(new BasicStroke(1.0f,
                BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_MITER,
                2.0f, dash1, 0.0f));
    }

    void disableSelectionStyle(Graphics graphics) {
        graphics.setColor(color);
        Graphics2D g2 = (Graphics2D) graphics;
        g2.setStroke(new BasicStroke());
    }


    @Override
    public void paint(Graphics graphics) {
        if (isSelected()) {
            enableSelectionStyle(graphics);
        } else {
            disableSelectionStyle(graphics);
        }
    }

    @Override
    public String toString() {
        return "BaseShape{" +
                "x=" + x +
                ", y=" + y +
                ", color=" + color +
                ", selected=" + selected +
                '}';
    }


    public abstract Shape clone();

}
