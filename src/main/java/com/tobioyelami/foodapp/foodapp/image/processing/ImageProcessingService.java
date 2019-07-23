package com.tobioyelami.foodapp.foodapp.image.processing;

import com.tobioyelami.foodapp.foodapp.restaurant.exceptions.AppServiceException;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by toyelami on 19/07/2019
 */
public class ImageProcessingService {

    //crop
    //resize
//    private Image image;
//    private Image croppedImage;
//
//    public File crop(File originalImage, int width, int height){
//        return  null;
//    }

    public File resize(File originalImage, int width, int height, String destinationPath) throws AppServiceException{
        try {
            BufferedImage original = ImageIO.read(originalImage);
            BufferedImage resized = new BufferedImage(width, height, original.getType());
            Graphics2D graphics2D = resized.createGraphics();
            graphics2D.drawImage(original, 0, 0, width, height, null);
            graphics2D.dispose();

            File destination = new File(destinationPath);
            ImageIO.write(resized, "png", destination);

            return destination;

        } catch (IOException e) {
            throw new AppServiceException();
        }
    }



}
