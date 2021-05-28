import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class DirReduction {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"})));
		System.out.println(Arrays.toString(first(new Integer[]{1, 1, 1, 2, 2, 1, 4, 3, 4, 3, 3, 2, 2})));
	}
	
	public static String[] dirReduc(String[] arr) {
		List<String> result = new ArrayList<>(Arrays.asList(arr));
		for (int i = 0; i < result.size() - 1; ) {
			if (result.get(i).equals("NORTH") && result.get(i + 1).equals("SOUTH")
						  || result.get(i).equals("WEST") && result.get(i + 1).equals("EAST")
						  || result.get(i).equals("EAST") && result.get(i + 1).equals("WEST")
						  || result.get(i).equals("SOUTH") && result.get(i + 1).equals("NORTH")) {
				result.remove(i);
				result.remove(i);
				if (i > 0) i--;
			} else {
				i++;
			}
		}
		return result.toArray(new String[0]);
	}
	
	public static Integer[] first(Integer[] arr) {
		List<Integer> result = new ArrayList<>(Arrays.asList(arr));
		ListIterator<Integer> iterator = result.listIterator();
		while (iterator.hasNext()) {
			Integer firstItem = iterator.next();
			if (iterator.hasNext() && firstItem.equals(iterator.next())) {
				iterator.remove();
				iterator.previous();
				iterator.remove();
				if (iterator.hasPrevious()) iterator.previous();
			} else {
				if (iterator.hasNext()) iterator.previous();
			}
		}
		return result.toArray(new Integer[0]);
	}
}