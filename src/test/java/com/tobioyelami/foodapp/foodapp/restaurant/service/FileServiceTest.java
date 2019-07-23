package com.tobioyelami.foodapp.foodapp.restaurant.service;

import com.sun.tools.corba.se.idl.InvalidArgument;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by toyelami on 08/04/2019
 */
public class FileServiceTest {

    private FileService fileService = new FileService();


    @Test
    public void getFileExceptionReturn() throws InvalidArgument{
        String fileName = "filename.png";
        assertEquals("png", fileService.getExtension(fileName));
    }

    @Test(expected = InvalidArgument.class)
    public void whenExceptionThrown_thenExpectationSatisfied() throws InvalidArgument{
        fileService.getExtension(null);
    }

    @Test
    public void testSave_whenFileIsNull(){
        System.out.println(LocalDateTime.of(LocalDate.now().minusDays(1), LocalTime.of(0,0,0)));
        System.out.println(LocalDateTime.of(LocalDate.now().minusDays(1), LocalTime.of(23,59,59)));
//        MockMultipartFile file = new MockMultipartFile("File.png", null);
    }

}
