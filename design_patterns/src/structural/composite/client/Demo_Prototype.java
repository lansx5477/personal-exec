package structural.composite.client;

import structural.composite.component.Circle;
import structural.composite.component.CompoundShape;
import structural.composite.component.Dot;
import structural.composite.component.Rectangle;

import java.awt.*;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: xiaoyl
 * @Date: 2023/07/11/17:33
 * @Description:
 */
public class Demo_Prototype {
    public static void main(String[] args) {

        Circle circle = new Circle(10, 10, 10, Color.BLUE);
        System.out.println(circle);
        System.out.println("---------------clone---------------");
        System.out.println(circle.clone());
        System.out.println();
        System.out.println(circle.toString().equals(circle.clone().toString()));
        System.out.println();


        CompoundShape compoundShape = new CompoundShape(
                new Circle(110, 110, 50, Color.RED),
                new Dot(160, 160, Color.RED)
        );
        System.out.println(compoundShape);
        System.out.println("---------------clone---------------");
        System.out.println(compoundShape.clone());
        System.out.println();
        System.out.println(compoundShape.toString().equals(compoundShape.clone().toString()));
        System.out.println();

        CompoundShape shape = new CompoundShape(
                new Rectangle(250, 250, 100, 100, Color.GREEN),
                new Dot(240, 240, Color.GREEN),
                new Dot(240, 360, Color.GREEN),
                new Dot(360, 360, Color.GREEN),
                compoundShape
        );
        System.out.println(shape);
        System.out.println("---------------clone---------------");
        System.out.println(shape.clone());
        System.out.println();
        System.out.println(shape.toString().equals(shape.clone().toString()));
        System.out.println();
    }

}
