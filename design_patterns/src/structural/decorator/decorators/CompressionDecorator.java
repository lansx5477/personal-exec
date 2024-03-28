package structural.decorator.decorators;

import structural.decorator.component.DataSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

/**
 *
 * @Author: xiaoyl
 * @Date: 2023/07/11/20:02
 * @Description: 压缩装饰器，在写入数据时进行压缩操作，读取数据时进行解压缩
 */
public class CompressionDecorator extends DataSourceDecorator{

    /**
     * 压缩等级
     */
    private int compLevel = 6;

    public CompressionDecorator(DataSource source) {
        super(source);
    }

    public int getCompressionLevel() {
        return compLevel;
    }

    public void setCompressionLevel(int value) {
        compLevel = value;
    }


    @Override
    public void writeData(String data) {
        super.writeData(data);
    }

    @Override
    public String readData() {
        return super.readData();
    }

    /**
     * 压缩数据
     * @param stringData
     * @return
     */
    private String compress(String stringData) {
        byte[] data = stringData.getBytes();
        ByteArrayOutputStream bout = new ByteArrayOutputStream(512);
        DeflaterOutputStream dos = new DeflaterOutputStream(bout, new Deflater(compLevel));
        try {
            dos.write(data);
            return Base64.getEncoder().encodeToString(bout.toByteArray());
        } catch (IOException e) {
            return null;
        } finally {
            if (dos != null) {
                try {
                    dos.flush();
                    dos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (bout != null) {
                try {
                    bout.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


    /**
     * 解压缩
     * @param stringData
     * @return
     */
    private String decompress(String stringData) {

        byte[] data = Base64.getDecoder().decode(stringData);
        InputStream in = null;
        InflaterInputStream iin = null;
        ByteArrayOutputStream bout = null;


        try {
            in = new ByteArrayInputStream(data);
            iin = new InflaterInputStream(in);
            bout = new ByteArrayOutputStream(512);
            int b = 0;
            while ((b = iin.read()) != -1) {
                bout.write(b);
            }
            return new String(bout.toByteArray());
        } catch (Exception e) {
            return null;
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (iin != null) {
                try {
                    iin.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (bout != null) {
                try {
                    bout.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }





    }
}
