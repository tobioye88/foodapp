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

    @Test
    public void character(){
        /*0 1
0 3
4 5
5 6
4 10*/
        List<List<Integer>> keyTimes = new ArrayList<>();
        keyTimes.add(new ArrayList<>(Arrays.asList(0,3)));
        keyTimes.add(new ArrayList<>(Arrays.asList(4,5)));
        keyTimes.add(new ArrayList<>(Arrays.asList(5,6)));
        keyTimes.add(new ArrayList<>(Arrays.asList(4,10)));



        int slowestChar = 0;
        int previousTime = 0;
        int difference = 0;
        for(List<Integer> keys: keyTimes){
            int ch = keys.get(0);
            int time = keys.get(1);
            int currentDifference =  time - previousTime;
            if(currentDifference > difference){
                slowestChar = ch;
                difference = currentDifference;
            }
            previousTime = time;
        }
        System.out.println( (char) (97 + slowestChar) );
    }


    @Test
    public void marks(){

        int k = 4;
        List<Integer> marks = new ArrayList<>(Arrays.asList(2,2,3,4,5));

        Collections.sort(marks);
        System.out.println(marks);
        Collections.reverse(marks);
        System.out.println(marks);

        int kTH = marks.get(k-1);
        int count = 0;

        for(int score: marks){
            if(score >= kTH && kTH != 0){
                count++;
            }
        }
        System.out.println(count);
    }

    @Test
    public void charx(){
        for(int i = 0; i < 200; i++) {
            System.out.println(i + " " + (char) i);
        }
    }
}
