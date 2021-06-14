import java.util.*;

class PermutationsMain {
	private static Set<String> result;
	private static String src;
	
	public static List<String> singlePermutations(String args) {
		result = new HashSet<>();
		src = args;
		divideAndConqueror(src.toCharArray(), 0);
		return new ArrayList<>(result);
	}
	
	public static void divideAndConqueror(char[] arraySRC, int fromIndex) { // 4 elements [a,b,c,d] == [0,1,2,3]
		if (arraySRC.length == 1){
			result.add(String.valueOf(arraySRC[0]));
			return;
		}
		if (arraySRC.length - fromIndex == 2) {
			result.add(new String(arraySRC));
			swap(fromIndex, arraySRC.length - 1, arraySRC);
			result.add(new String(arraySRC));
			return;
		}
		
		for (int i = fromIndex; i < arraySRC.length; i++) {
			swap(fromIndex, i, arraySRC);
			divideAndConqueror(Arrays.copyOf(arraySRC, arraySRC.length), fromIndex + 1);
			swap(i, fromIndex, arraySRC);
		}
	}
	
	public static char[] swap(int first, int second, char[] arr) {
		char temp = arr[first];
		arr[first] = arr[second];
		arr[second] = temp;
		return arr;
	}
//	public static void main(String[] args) {
//		System.out.println(singlePermutations("abcd"));
//	}
}