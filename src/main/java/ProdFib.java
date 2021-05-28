import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProdFib {
	public static long[] productFib(long prod) {
		List<Long> sequence = new ArrayList<>(Arrays.asList(1L, 1L));
		long[] result = new long[3];
		Long currentProd;
		for (int i = 0; true; i++) {
			sequence.add(sequence.get(i) + sequence.get(i + 1));
			currentProd = sequence.get(i) * sequence.get(i + 1);
			if (currentProd == prod) {
				result[0] = sequence.get(i);
				result[1] = sequence.get(i + 1);
				result[2] = 1L;
				return result;
			}
			if (currentProd > prod) {
				result[0] = sequence.get(i);
				result[1] = sequence.get(i + 1);
				result[2] = 0L;
				return result;
			}
		}
	}
}
