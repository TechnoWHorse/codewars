import java.util.regex.Pattern;

public class Main {
	public static void main(String[] args) {
		System.out.println("oleg semen".matches("oleg|semen"));
		System.out.println(Pattern.compile("oleg").matcher("oleg asdas seamen").matches());
		
	}

}
