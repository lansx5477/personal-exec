package structural.facade.subsystem;

import structural.facade.component.VideoFile;

/**
 *
 * @author 28417
 */
public class BitrateReader {

    /**
     * 以指定解码器读取文件
     * @param file
     * @param codec
     * @return
     */
    public static VideoFile read(VideoFile file, Codec codec) {
        System.out.println("BitrateReader: reading file...");
        return file;
    }

    /**
     * 将文件转化为指定解码器类型
     * @param buffer
     * @param codec
     * @return
     */
    public static VideoFile convert(VideoFile buffer, Codec codec) {
        System.out.println("BitrateReader: writing file...");
        return buffer;
    }
}