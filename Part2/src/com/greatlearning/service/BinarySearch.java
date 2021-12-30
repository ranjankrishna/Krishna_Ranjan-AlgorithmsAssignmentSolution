package com.greatlearning.service;

public class BinarySearch {
	public void binarySearch(double[] array, int first, int last, double key) {
		int mid = (first + last) / 2;
		while (first <= last) {
			if (array[mid] < key) {
				first = mid + 1;
			} else if (array[mid] == key) {
				System.out.println("Stock of value " + key + " is present");
				break;
			} else {
				last = mid - 1;
			}
			mid = (first + last) / 2;
		}
		if (first > last) {
			System.out.println("Element not found in the array");
			mid = 0;
		}

	}
}
