package structural.composite.component;

import java.awt.*;

/**
 *
 * @Author: xiaoyl
 * @Date: 2023/07/11/10:45
 * @Description: 简单对象和复杂对象的通用接口
 */
public interface Shape {

    /**
     * 获取图形的x坐标
     * @return
     */
    int getX();

    /**
     * 获取图形的y坐标
     * @return
     */
    int getY();

    /**
     * 获取图形的宽
     * @return
     */
    int getWidth();

    /**
     * 获取图形的高
     * @return
     */
    int getHeight();


    /**
     * 获取图形的颜色
     * @return
     */
    Color getColor();

    /**
     * 获取图形是否被选中
     * @return
     */
    Boolean getSelected();

    /**
     * 移动图形到新位置(sourceX+x, sourceY+y)
     * @param x
     * @param y
     */
    void move(int x, int y);

    /**
     * 是否在边界内
     * @param x
     * @param y
     * @return
     */
    boolean isInsideBounds(int x, int y);

    /**
     * 选择
     */
    void select();

    /**
     * 不选
     */
    void unSelect();

    /**
     * 判断是否被选中
     * @return
     */
    boolean isSelected();

    /**
     * 绘制
     * @param graphics
     */
    void paint(Graphics graphics);


    /**
     * 原型模式
     * 克隆当前对象
     * @return
     */
    Shape clone();

}
