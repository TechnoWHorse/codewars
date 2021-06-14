package wrong;

import java.util.*;

class Permutations {
	
	public static List<String> singlePermutations(String s) {
		Set<String> resultFilter = new LinkedHashSet<>();
		char[] wtf = s.toCharArray();
		if (s.length()==0)return null;
		for (int x = 0; x < s.length(); x++) {
			char[] arr = s.toCharArray();
			char buff = arr[1];
			arr[1] = arr[x];
			arr[x] = buff;
			resultFilter.add(new String(arr));
			
			for (int z = 0; z < s.length(); z++) {
				char buff3 = arr[x];
				arr[x] = arr[z];
				arr[z] = buff3;
				resultFilter.add(new String(arr));
				
				for (int i = 0; i < s.length(); i++) {
					
					for (int j = 0; j < s.length() - 1; j++) {
						char buff2 = arr[j + 1];
						arr[j + 1] = arr[j];
						arr[j] = buff2;
						resultFilter.add(new String(arr));
					}
				}
			}
		}
//		System.out.println(resultFilter);
		List<String> temp = new ArrayList<>(resultFilter);
		Collections.sort(temp);
		return temp;
	}
	public static void main(String[] args) {
		System.out.println(singlePermutations("abcd"));
		System.out.println(singlePermutations("abc"));
	}
}