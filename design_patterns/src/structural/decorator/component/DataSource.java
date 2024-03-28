package structural.decorator.component;

/**
 *
 * @Author: xiaoyl
 * @Date: 2023/07/11/19:39
 * @Description:
 */
public interface DataSource {

    /**
     * 写入数据
     * @param data
     */
    void writeData(String data);

    /**
     * 读取数据
     * @return
     */
    String readData();
}
