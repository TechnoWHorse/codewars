import java.util.ArrayList;
import java.util.List;

public class TimeFormatter {
	
	public static String formatDuration(long arg) {
		List<String> resultHolder = new ArrayList<>();
		StringBuilder result = new StringBuilder();
		
		var years = arg / (31536000);
		var days = (arg % (31536000)) / (86400);
		var hours = (arg % (86400)) / (3600);
		var minutes = (arg % (3600)) / 60;
		var seconds = arg % 60;
		
		if (years != 0) resultHolder.add(years + (years == 1 ? " year" : " years"));
		if (days != 0) resultHolder.add(days + (days == 1 ? " day" : " days"));
		if (hours != 0) resultHolder.add(hours + (hours == 1 ? " hour" : " hours"));
		if (minutes != 0) resultHolder.add(minutes + (minutes == 1 ? " minute" : " minutes"));
		if (seconds != 0) resultHolder.add(seconds + (seconds == 1 ? " second" : " seconds"));
		if (resultHolder.size() == 0) return "now";
		if (resultHolder.size() == 1) return resultHolder.get(0);
		
		for (int i = 0; i < resultHolder.size() - 2; i++) {
			result.append(resultHolder.get(i)).append(", ");
		}
		
		return result.append(resultHolder.get(resultHolder.size() - 2)).append(" and ").append(resultHolder.get(resultHolder.size() - 1)).toString();
	}
	public static void main(String[] args) {
		System.out.println(formatDuration(34234234));
	}
}
