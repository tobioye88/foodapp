package com.tobioyelami.foodapp.foodapp.image.processing;

import com.tobioyelami.foodapp.foodapp.restaurant.exceptions.AppServiceException;
import org.junit.Test;

import java.io.File;

/**
 * Created by toyelami on 19/07/2019
 */
public class ImageProcessingServiceTest {

    ImageProcessingService imageProcessingService = new ImageProcessingService();

    @Test
    public void testThatImageIsResized(){
        File file = new File("images/resized.jpg");
        try {
            File resized = imageProcessingService.resize(file, 300, 300, "images/resized1.jpg");
        } catch (AppServiceException e) {
            e.printStackTrace();
        }
    }

}