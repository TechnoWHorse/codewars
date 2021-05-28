import java.util.*;

public class DirectoriNavigation {
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(dirReduce(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH","EAST"})));
	}
	public static String[] dirReduce(String[] arr) {
		List<String> result = new ArrayList<>();
		Stack<Integer> westPositions = new Stack<>();
		Stack<Integer> eastPositions = new Stack<>();
		Stack<Integer> northPositions = new Stack<>();
		Stack<Integer> southPositions = new Stack<>();
		
		for (int i = 0; i < arr.length; i++) {
			switch (arr[i]) {
				case "WEST":
					if (!result.contains("EAST")) {
						result.add(arr[i]);
						westPositions.push(i);
					} else {
						result.add(null);
						result.set(eastPositions.pop(), null);
					}
					break;
				
				case "EAST":
					if (!result.contains("WEST")) {
						result.add(arr[i]);
						eastPositions.push(i);
					} else {
						result.add(null);
						result.set(westPositions.pop(), null);
					}
					break;
				
				case "NORTH":
					if (!result.contains("SOUTH")) {
						result.add(arr[i]);
						northPositions.push(i);
					} else {
						result.add(null);
						result.set(southPositions.pop(), null);
					}
					break;
				
				case "SOUTH":
					if (!result.contains("NORTH")) {
						result.add(arr[i]);
						southPositions.push(i);
					} else {
						result.add(null);
						result.set(northPositions.pop(), null);
					}
					break;
			}
			
		}
		result.removeIf(Objects::isNull);
		return result.toArray(new String[0]);
	}
}
