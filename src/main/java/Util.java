//D:\nioTuttorial\src\main\java\librarry

import java.util.Random;

public class Util {
	
	public static int[] getRandomArr(int length, int limit) {
		int[] result = new int[length];
		Random rand = new Random();
		for (int i = 0; i < result.length; i++) {
			result[i] = rand.nextInt(limit);
		}
		return result;
	}
	
	public static long stopwatch(Runnable method) {
		long start = System.currentTimeMillis();
		method.run();
		return System.currentTimeMillis() - start;
	}
}
