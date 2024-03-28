package structural.facade.subsystem;

import structural.facade.component.VideoFile;

import java.io.File;

/**
 * 音频处理
 * @author 28417
 */
public class AudioMixer {
    public File fix(VideoFile result){
        System.out.println("AudioMixer: fixing audio...");
        return new File("tmp");
    }
}