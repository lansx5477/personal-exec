package structural.decorator.decorators;

import structural.decorator.component.DataSource;

/**
 *
 * @Author: xiaoyl
 * @Date: 2023/07/11/19:48
 * @Description: 装饰器基类，装饰基类会将所有操作委派给被封装的对象
 */
public class DataSourceDecorator implements DataSource {

    private DataSource wrapper;

    public DataSourceDecorator(DataSource source) {
        this.wrapper = source;
    }

    @Override
    public void writeData(String data) {
        wrapper.writeData(data);
    }

    @Override
    public String readData() {
        return wrapper.readData();
    }

}
