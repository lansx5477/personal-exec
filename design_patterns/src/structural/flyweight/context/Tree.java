package structural.flyweight.context;

import structural.flyweight.flyweight.TreeType;

import java.awt.*;

/**
 * 包含每棵树的独特状态
 *
 * @Author: xiaoyl
 * @Date: 2023/07/12/21:42
 * @Description: 情景
 */
public class Tree {

    private int x;
    private int y;
    /**
     * 指向具体享元的引用
     */
    private TreeType type;


    public Tree(int x, int y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    /**
     * 调用享元类中的原始对象行为（传入外在状态）
     * @param g
     */
    public void draw(Graphics g) {
        type.draw(g, x, y);
    }

}
