public class Test {
	public static void main(String[] args) {
		System.out.println(isPrime(Integer.MAX_VALUE));
	}
	public static boolean isPrime(int num) {
		boolean result = true;
		int y = 0;
		if (num == 2)
			return result;
		if (num == 3)
			return result;
		if (num == 5)
			return result;
		if (num == 7)
			return result;
		
		if (num % 2 == 0 || num % 3 == 0 || num % 5 == 0 || num % 7 == 0) {
			result = false;
			return result;
		}
		
		if (num > 1) {
			for (int i = 5; i * i <= num; i = i + 2) {
				if (num % i == 0) {
					result = false;
					break;
				}
			}
		} else
			result = false;
		return result;
	}
}
