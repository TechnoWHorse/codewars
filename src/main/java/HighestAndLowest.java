import java.util.Arrays;

public class HighestAndLowest {
	public static void main(String[] args) {
		System.out.println(HighestAndLowest.highAndLow("12 3 2123 -123 11"));
	}
	public static String highAndLow(String numbers) {
		int[] arr = Arrays.stream(numbers.split(" ")).mapToInt(x->Integer.parseInt(x)).toArray();
		int max = arr[0];
		int min = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if(max<arr[i]) max=arr[i];
			if(min>arr[i]) min=arr[i];
		}
		return max + " " + min;
	}
}
