import java.util.HashMap;
import java.util.Map;

public class Dinglemouse {
	int counter;
	Map<String, Integer> positions = new HashMap<>();
	String[] result = {"", "", ""};
	String name;
	int age;
	char sex;
	
	
	public Dinglemouse() {
		positions.put("name", null);
		positions.put("age", null);
		positions.put("sex", null);
	}
	
	public Dinglemouse setAge(int age) {
		this.age = age;
		positions.computeIfAbsent("age", k -> counter++);
		result[positions.get("age")] = " I am " + age + ".";
		return this;
	}
	
	public Dinglemouse setSex(char sex) {
		this.sex = sex;
		positions.computeIfAbsent("sex", k -> counter++);
		result[positions.get("sex")] = " I am " + (sex == 'M' ? "male" : "female") + ".";
		return this;
	}
	
	public Dinglemouse setName(String name) {
		this.name = name;
		positions.computeIfAbsent("name", k -> counter++);
		result[positions.get("name")] = " My name is " + name + ".";
		return this;
	}
	
	public String hello() {
		StringBuilder result = new StringBuilder("Hello.");
		for (String param : this.result) {
			result.append(param);
		}
		this.result = new String[]{"", "", ""};
		positions = new HashMap<>();
		counter=0;
		return result.toString();
	}
	
	public static void main(String[] args) {
		
		System.out.println(new Dinglemouse().setAge(27).setSex('M').setName("Bob").hello());
		String expected = "Hello. I am 27. I am male. My name is Bob.";
		
		
	}
}
