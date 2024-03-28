package structural.decorator.client;

import structural.decorator.component.DataSource;
import structural.decorator.component.FileDataSource;
import structural.decorator.decorators.CompressionDecorator;
import structural.decorator.decorators.DataSourceDecorator;
import structural.decorator.decorators.EncryptionDecorator;

/**
 *
 * @Author: xiaoyl
 * @Date: 2023/07/11/20:41
 * @Description:
 */
public class Demo {
    public static void main(String[] args) {
        String salaryRecords = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000";
        DataSourceDecorator encoded = new CompressionDecorator(
                new EncryptionDecorator(
                        new FileDataSource("out/OutputDemo.txt")));
        encoded.writeData(salaryRecords);
        DataSource plain = new FileDataSource("out/OutputDemo.txt");

        System.out.println("- Input ----------------");
        System.out.println(salaryRecords);
        System.out.println("- Encoded --------------");
        System.out.println(plain.readData());
        System.out.println("- Decoded --------------");
        System.out.println(encoded.readData());
    }
}
