import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DigPow {
	public static void main(String[] args) {
		int n = 2378946;
		int p;
		digPow(533, 2);
	}
	public static long digPow(int n, int p) {
		int[] arr = Arrays.stream(Integer.toString(n).split("")).mapToInt(Integer::parseInt).toArray();
		int result = 0;
		for (int i = 0; i < arr.length; p++, i++) {
			result += Math.pow(arr[i], p);
		}
		if (result % n == 0) return (result / n);
		return -1;
	}
}
