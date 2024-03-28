package structural.flyweight.client;

import structural.flyweight.context.Tree;
import structural.flyweight.factory.TreeFactory;
import structural.flyweight.flyweight.TreeType;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 绘制的森林
 * @Author: xiaoyl
 * @Date: 2023/07/12/22:06
 * @Description:
 */
public class Forest extends JFrame {

    private List<Tree> trees = new ArrayList<>();

    public void plantTree(int x, int y, String name, Color color, String otherTreeData) {
        // 享元工厂获取享元对象
        TreeType type = TreeFactory.getTreeType(name, color, otherTreeData);
        // 构建情景对象
        Tree tree = new Tree(x, y, type);
        trees.add(tree);
    }

    @Override
    public void paint(Graphics graphics) {
        for (Tree tree : trees) {
            tree.draw(graphics);
        }
    }

}
