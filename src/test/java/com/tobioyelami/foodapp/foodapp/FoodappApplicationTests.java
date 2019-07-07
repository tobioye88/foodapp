package com.tobioyelami.foodapp.foodapp;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

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
		List<String> list = new ArrayList<>();
		for (int i = 0; i < 50; i++) {
			int number = (int) (Math.random() * ( 4000 - 1000 ));
			list.add("" + number);
		}
		return list;
	}

	@Test
	public void test(){
        String[] numArr =  new String[] {"001", "004", "003", "006", "002"};
		List<String> numberList = new ArrayList<>(Arrays.asList(numArr));
//		numberStr.sort();
		System.out.println(numberList);
		Collections.sort(numberList);
		System.out.println(numberList);
	}

	@Test
	public void java8(){
		String[] numArr =  new String[] {"001", "004", "003", "006", "002"};
		List<String> strings = Arrays.asList(numArr);
		List<Integer> numberList;
		numberList = strings.stream().map(Integer::parseInt).collect(Collectors.toList());
		Optional<Integer> first = strings.stream().map(Integer::parseInt).findFirst();
		first.ifPresent(System.out::println);
		System.out.println();
//		System.out.println(integer);
		System.out.println("number list size " + numberList.size());
	}





}

