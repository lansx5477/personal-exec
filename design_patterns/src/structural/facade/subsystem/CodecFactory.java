package structural.facade.subsystem;

import structural.facade.component.VideoFile;

/**
 * 解码器工厂
 * @author 28417
 */
public class CodecFactory {

    /**
     * 提取媒体文件对应的解码器
     * @param file
     * @return
     */
    public static Codec extract(VideoFile file) {
        String type = file.getCodecType();
        if (type.equals("mp4")) {
            System.out.println("CodecFactory: extracting mpeg audio...");
            return new MPEG4CompressionCodec();
        }
        else {
            System.out.println("CodecFactory: extracting ogg audio...");
            return new OggCompressionCodec();
        }
    }
}