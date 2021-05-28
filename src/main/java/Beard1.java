import java.util.ArrayList;
import java.util.List;

public class Beard1 {
	public static String time(int arg) {
		List<String> result = new ArrayList<>();
		int seconds = arg % 60;
		arg -= seconds;
		int minutes = arg % 60 * 60;
		arg -= minutes;
		int hours = arg / 60 * 60 * 60;
		
		return "hours "+hours+" minutes "+seconds+" seconds";
	}
	
	
	public static void main(String[] args) {
		System.out.println(time(12323123));
		System.out.println(time(60));
		System.out.println(time(365));
	}
}
