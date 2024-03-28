package structural.facade.facedes;

import structural.facade.component.VideoFile;
import structural.facade.subsystem.*;

import java.io.File;

/**
 * 外观提供了进行视频转换的简单接口
 * 通常情况下， 外观管理着其所使用的对象的完整生命周期。
 *
 * @Author: xiaoyl
 * @Date: 2023/07/12/0:22
 * @Description:
 */
public class VideoConversionFacade {

    public File convertVideo(String fileName, String format) {
        System.out.println("VideoConversionFacade: conversion started.");
        VideoFile file = new VideoFile(fileName);
        Codec sourceCodec = CodecFactory.extract(file);
        Codec destinationCodec;
        if (format.equals("mp4")) {
            destinationCodec = new MPEG4CompressionCodec();
        } else {
            destinationCodec = new OggCompressionCodec();
        }
        VideoFile buffer = BitrateReader.read(file, sourceCodec);
        VideoFile intermediateResult = BitrateReader.convert(buffer, destinationCodec);
        File result = (new AudioMixer()).fix(intermediateResult);
        System.out.println("VideoConversionFacade: conversion completed.");
        return result;
    }

}
