public class PrimeNumber {
	public static boolean isPrime(int num) {
		if (num < 2) return false;
		if (num == 2) return true;
		for (int i = 3; i < num; i = +2) {
			if (num % i == 0) return false;
		}
		return true; //TODO
	}
}
