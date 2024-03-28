package structural.facade.component;

/**
 * 媒体文件类
 * @author 28417
 */
public class VideoFile {
    /**
     * 文件名
     */
    private String name;
    /**
     * 解码器类型
     */
    private String codecType;

    public VideoFile(String name) {
        this.name = name;
        this.codecType = name.substring(name.indexOf(".") + 1);
    }

    public String getCodecType() {
        return codecType;
    }

    public String getName() {
        return name;
    }
}