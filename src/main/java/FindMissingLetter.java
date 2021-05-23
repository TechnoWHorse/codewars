public class FindMissingLetter {
	public static void main(String[] args) {
		System.out.println(findMissingLetter("abcdetfg".toCharArray()));
	}
	public static char findMissingLetter(char[] array) {
		for (int i = 0, x = array[0]; i < array.length; i++, x++) {
			if (array[i] != x) return (char) x;
		}
		return array[0];
	}
}

