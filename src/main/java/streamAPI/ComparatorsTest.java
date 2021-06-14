package streamAPI;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class ComparatorsTest implements Comparable<ComparatorsTest> {
	String str;
	public static void main(String[] args) {
		List<User> list = List.of(new User("Oleg", 15)
				 , new User("Dragunov", 29)
				 , new User("Kido", 25)
				 , new User("pelbmehsa", 29)
				 , new User("AAA", 29))
										 .stream()
										 .sorted(Comparator.comparing((User u) -> u.age)
															 .thenComparing(u -> u.name, String.CASE_INSENSITIVE_ORDER))
										 .collect(Collectors.toList());
		System.out.println(list);
		Map<Integer, String> map = list.stream().collect(Collectors.toMap(User::getAge, User::getName,
				 BinaryOperator.minBy((x, y) -> {
					 if (x.charAt(0) == 'D') return -1;
					 if (y.charAt(0) == x.charAt(0)) return 0;
					 return +1;
				 })));
		System.out.println(map);
		
		
		System.out.println(Optional.of("13521").flatMap(x -> { // MANUAL FILTER
			try {
				return Optional.of(Integer.valueOf(x));
			} catch (Exception e) {
				return Optional.empty();
			}
		}).orElse(-1));
	}
	
	public ComparatorsTest(String str) {
		this.str = str;
	}
	@Override
	public int compareTo(@NotNull ComparatorsTest o) {
		return str.compareTo(o.str);
	}
}

class User {
	String name;
	int age;
	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "User{" +
						  "name='" + name + '\'' +
						  ", age=" + age +
						  '}';
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
