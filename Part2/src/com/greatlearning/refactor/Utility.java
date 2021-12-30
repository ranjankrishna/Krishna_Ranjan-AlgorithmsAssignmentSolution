package com.greatlearning.refactor;

public class Utility {
	public static void catalogue() {
		System.out.println();
		System.out.println();
		System.out.println("*****************************************************************************");
		System.out.println("Enter the operation that you want to perform");
		System.out.println("1. Display the companies stock prices in ascending order");
		System.out.println("2. Display the companies stock prices in descending order");
		System.out.println("3. Display the total no of companies for which stock prices rose today");
		System.out.println("4. Display the total no of companies for which stock prices declined today");
		System.out.println("5. Search a specific stock price");
		System.out.println("6. Press 0 to exit");
		System.out.println();
		System.out.println("*****************************************************************************");
	}

	public static void displayArray(int index, double array[]) {
		for (int i = index; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	public static int priceRise(int index, int size, boolean array[]) {
		int count = 0;
		for (int i = index; i < size; i++) {
			if (array[i] == true)
				count += 1;
		}
		return count;
	}

	public static int priceDecline(int index, int size, boolean array[]) {
		int count = 0;
		for (int i = index; i < size; i++) {
			if (array[i] == false)
				count += 1;
		}
		return count;
	}
}
