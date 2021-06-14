package streamAPI;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTutorial {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 4, 2, 1, 4, 7};
		String[] testString = {"Java", "Kotlin", "Groovy"};
		List<String> result = Arrays.stream(testString).peek(System.out::println).filter(x -> !x.matches("Java")).collect(Collectors.toList());
		System.out.println(result);
		List<Integer> result2 = Arrays.stream(arr)
												 .filter(x -> x != 7)
												 .peek(System.out::print).map(x -> x * 2).sorted()
												 .peek(System.out::print).distinct().boxed()
												 .collect(Collectors.toList());
		System.out.println(result2);
		
		List<List<String>> testFlatMap = List.of(
				 List.of("foo", "bar", "buz"),
				 List.of("Bue", "Good luck", "SYA"),
				 Arrays.stream(testString)
						  .sorted((x, y) -> x.length() < y.length() ? 1 : -1)
						  .collect(Collectors.toList()));
		
		System.out.println(testFlatMap.stream()
										  .peek(System.out::println).flatMap(Collection::stream)
										  .peek(System.out::println).collect(Collectors.joining(" "))
										  .chars().peek(x-> System.out.print(x+" "))
										  .peek(x-> System.out.print(x+" ")).mapToObj(x -> (char) x)
										  .map(String::valueOf).collect(Collectors.joining("")));
		
	}
}
