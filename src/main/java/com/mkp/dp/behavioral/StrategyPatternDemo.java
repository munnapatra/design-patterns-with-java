package com.mkp.dp.behavioral;

/**
 * The Strategy Pattern defines a family of algorithms,
 * encapsulates each one, and makes them interchangeable.
 * This pattern allows the client to choose an algorithm dynamically based on context or input.
 */
public class StrategyPatternDemo {
	public static void main(String[] args) {
		int[] unsortedData = { 5, 2, 9, 1, 6 };
		int[] sortedData = { 1, 2, 3, 4, 5 };

		// Use Linear Search strategy
		SearchContext context = new SearchContext(new LinearSearch());
		System.out.println("Linear Search Result: " + context.executeSearch(unsortedData, 6));

		// Switch to Binary Search strategy
		context = new SearchContext(new BinarySearch());
		System.out.println("Binary Search Result: " + context.executeSearch(sortedData, 3));
	}
}

class SearchContext {
	private SearchStrategy strategy;

	public SearchContext(SearchStrategy strategy) {
		this.strategy = strategy;
	}

	public int executeSearch(int[] data, int key) {
		return strategy.search(data, key);
	}
}

interface SearchStrategy {
	int search(int[] data, int key);
}

class LinearSearch implements SearchStrategy {
	@Override
	public int search(int[] data, int key) {
		for (int i = 0; i < data.length; i++) {
			if (data[i] == key)
				return i;
		}
		return -1;
	}
}

class BinarySearch implements SearchStrategy {
	@Override
	public int search(int[] data, int key) {
		int left = 0, right = data.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (data[mid] == key)
				return mid;
			if (data[mid] < key)
				left = mid + 1;
			else
				right = mid - 1;
		}
		return -1;
	}
}