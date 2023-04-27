package demo;

import java.util.Arrays;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		
		List<Integer> al=Arrays.asList(2,3,5,4,7,6,9,8);
		al.stream().sorted().forEach(System.out::println);

	}

}
