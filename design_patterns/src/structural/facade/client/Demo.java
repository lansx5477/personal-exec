package structural.facade.client;

import structural.facade.facedes.SingleFacadeFactory;
import structural.facade.facedes.VideoConversionFacade;

import java.io.File;

/**
 * @author 28417
 */
public class Demo {

    public static void main(String[] args) {
        VideoConversionFacade converter = SingleFacadeFactory.getVideoConversionFacade();
        File mp4Video = converter.convertVideo("youtubevideo.ogg", "mp4");
        // ...
    }
}