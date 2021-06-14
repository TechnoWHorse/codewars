import java.util.Stack;

public class recursive {
	public static void main(String[] args) {
		System.out.println(fibNoArr(14, 0));
		System.out.println(fibArr(14, new long[]{0, 1}));
		System.out.println(fib2(14, new Stack<>()));
		System.out.println(fib(14));
	}
	
	public static long fibArr(int n, long[] buff) {
		if (n <= 0) {
//			buff[0] = 1;
			return 1;
		}
		long temp = fibArr(n - 1, buff);
		buff[0] = buff[1] + buff[0];
		buff[1] = temp;
		return buff[0];
	}
	public static long fibNoArr(int n, long buff) {
		if (n <= 0) {
			return 1;
		}
		buff = fibNoArr(n - 1, buff);
		return buff + fibNoArr(n - 2, buff);
		
	}
	
	public static long factorial(long start) {
		if (start == 1) return 1;
		return start * factorial(start - 1);
	}
	
	public static long fib(int n) {
		if (n <= 1) return 1;
		return fib(n - 1) + fib(n - 2);
	}
	int counter;
	public static long fib2(int n, Stack<Long> mem) {
		if (n <= 1) return 1;
		mem.add(fib2(n - 1, mem));
		if (mem.size() > 1) return mem.lastElement() + mem.get(mem.size() - 2);
		return 1;
	}
	
	
	public static long fib3(int n, long mem) {
		if (n <= 1) return 1;
		if (mem > 0) return mem + fib3(n - 1, mem);
		return fib3(n - 1, mem);
	}
}
