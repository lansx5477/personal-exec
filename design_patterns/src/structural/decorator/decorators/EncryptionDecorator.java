package structural.decorator.decorators;

import structural.decorator.component.DataSource;

import java.util.Base64;

/**
 *
 * @Author: xiaoyl
 * @Date: 2023/07/11/19:53
 * @Description: 加密装饰器（读取文件时进行解密操作，写入文件时对数据进行加密）
 */
public class EncryptionDecorator extends DataSourceDecorator{

    public EncryptionDecorator(DataSource source) {
        super(source);
    }

    @Override
    public void writeData(String data) {
        super.writeData(encode(data));
    }

    @Override
    public String readData() {
        return decode(super.readData());
    }

    /**
     * 加密
     * @param data
     * @return
     */
    private String encode(String data) {
        byte[] result = data.getBytes();
        for (int i = 0; i < result.length; i++) {
            result[i] += (byte) 1;
        }
        return Base64.getEncoder().encodeToString(result);
    }

    /**
     * 解密
     * @param data
     * @return
     */
    private String decode(String data) {
        byte[] result = Base64.getDecoder().decode(data);
        for (int i = 0; i < result.length; i++) {
            result[i] -= (byte) 1;
        }
        return new String(result);
    }
}
