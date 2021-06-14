public class GreedyAlgorithms {
	public static void main(String[] args) {
		System.out.println(minStops(new int[]{0, 200, 375, 550, 750, 950}, 400));
		final Item[] items = {new Item(4, 20), new Item(3, 18), new Item(2, 14)};
		System.out.println(getPrice(items, 7));
	}
	
	public static int minStops(int[] stops, int capacity) {
		int result = 0; //optimal
		int currentStop = 0;
		int temp = 0;
		for (int stop : stops) {
			if (stop < currentStop + capacity) {
				temp = stop;
			} else {
				currentStop = temp;
				result++;
			}
		}
		return result;
	}
	public static int getPrice(@org.jetbrains.annotations.NotNull Item[] items, int maxW) { //w,price
		int result = 0;
		int currentW = 0;
		boolean isSorted = false;
		int j = items.length;
		while (!isSorted) {
			isSorted = true;
			for (int i = 1; i < j; i++) {
				if (items[i - 1].getValuePerWeight() < items[i].getValuePerWeight()) {
					Item temp = items[i - 1];
					items[i - 1] = items[i];
					items[i] = items[i - 1];
					isSorted = false;
				}
			}
			j--;
		}
		for (Item item : items) {
			if (currentW < maxW) {
				if (item.getWeight() + currentW < maxW) {
					result += item.getValue();
					currentW += item.getWeight();
				} else {
					for (int i = 0; i < item.getWeight(); i++) {
						if (currentW < maxW) {
							result += item.getValuePerWeight();
							currentW++;
						}
					}
				}
			}
		}
		return result;
	}
}

class Item {
	private int weight;
	private int value;
	
	public Item(int weight, int value) {
		this.weight = weight;
		this.value = value;
	}
	
	public double getValuePerWeight() {
		return this.value / (double) this.weight;
	}
	
	public int getWeight() {
		return weight;
	}
	public int getValue() {
		return value;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "Item{" +
						  "weight=" + weight +
						  ", value=" + value +
						  '}';
	}
}
