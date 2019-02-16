package com.tobioyelami.foodapp.foodapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class FoodappApplicationTests {

	@Test
	public void contextLoads() {
		List<String> stringIds = getStringIds();
//		stringIds.sort(String::compareTo);
		stringIds.sort((s1, s2) -> {
			if (Integer.valueOf(s1).equals(Integer.valueOf(s2)))
				return 0;
			else if (Integer.valueOf(s1) > Integer.valueOf(s2))
				return 1;
			else
				return -1;
		});
		List<Integer> intIds = convertToInt(stringIds);
		Collections.sort(intIds);
		System.out.println(stringIds);
		System.out.println(intIds);
	}
	public List<Integer> convertToInt(List<String> list){
		List<Integer> intIds = new ArrayList<>();
		for(String val : list){
			intIds.add(Integer.valueOf(val));
		}
		return intIds;
	}

	public static List<String> getStringIds(){
		List<String> list = new ArrayList();
		Random random = new Random();
		for (int i = 0; i < 50; i++) {
			int number = (int) (Math.random() * ( 4000 - 1000 ));
			list.add("" + number);
		}
		return list;
	}

}

