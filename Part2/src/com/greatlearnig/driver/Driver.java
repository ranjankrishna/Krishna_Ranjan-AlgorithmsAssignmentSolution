package com.greatlearnig.driver;

import java.util.InputMismatchException;
import com.greatlearning.service.*;
import com.greatlearning.refactor.*;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int size;
			try {
				System.out.println("Enter the number of companies ");
				size = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Please eter number of companies in numeric format ");
				return;
			}
			int[] noOfCompanies = new int[size];
			double[] stockPriceOfCompany = new double[size];
			boolean[] priceRise = new boolean[size];
			for (int i = 0; i < size; i++) {
				System.out.println("Enter current stock price of the company " + (i + 1));
				noOfCompanies[i] = (i + 1);
				try {
					double price = sc.nextDouble();
					stockPriceOfCompany[i] = price;
					System.out.println("Whether company's stock price rose today compare to yesterday?");
				} catch (InputMismatchException e) {
					System.out.println("Please enter price in numeric format ");
					return;
				}

				try {
					boolean riseInPrice = sc.nextBoolean();
					priceRise[i] = riseInPrice;
				} catch (Exception e) {
					System.out.println("Please enter true/false");
					return;
				}
			}
			System.out.println();
			System.out.println("Input Data");
			for (int i = 0; i < size; i++) {
				System.out.println(" Company " + noOfCompanies[i] + "| Stock Price " + stockPriceOfCompany[i]
						+ "| Rise in Price - " + priceRise[i]);
			}

			boolean exit = false;
			while (exit != true) {
//				Catalog of options
				Utility.catalogue();
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					if (stockPriceOfCompany.length > 1) {
						MergeSortAscending mergeSortAscending = new MergeSortAscending();
						mergeSortAscending.sort(stockPriceOfCompany, 0, stockPriceOfCompany.length - 1);
						System.out.println("Stock prices in ascending order are :");
						Utility.displayArray(0, stockPriceOfCompany);
					} else if (stockPriceOfCompany.length == 1) {
						System.out.println("Stock prices in ascending order are : " + stockPriceOfCompany[0]);
					}
					break;
				case 2:
					if (stockPriceOfCompany.length > 1) {
						MergeSortDescending mergeSortDescending = new MergeSortDescending();
						mergeSortDescending.sort(stockPriceOfCompany, 0, stockPriceOfCompany.length - 1);
						System.out.println("Stock prices in descending order are :");
						Utility.displayArray(0, stockPriceOfCompany);
					} else if (stockPriceOfCompany.length == 1) {
						System.out.println("Stock prices in descending order are : " + stockPriceOfCompany[0]);
					}
					break;
				case 3:
					int count = 0;
					count = Utility.priceRise(0, size, priceRise);
					System.out.println("Total no of companies whose stock price rose today :  " + count);
					break;
				case 4:
					count = 0;
					count = Utility.priceDecline(0, size, priceRise);
					System.out.println("Total no of companies whose stock price declined today : " + count);
					break;
				case 5:
					System.out.println("Enter the key value");
					double key = sc.nextDouble();
					MergeSortAscending mergeSortAscending = new MergeSortAscending();
					mergeSortAscending.sort(stockPriceOfCompany, 0, stockPriceOfCompany.length - 1);
					BinarySearch binarysearch = new BinarySearch();
					binarysearch.binarySearch(stockPriceOfCompany, 0, stockPriceOfCompany.length - 1, key);
					break;
				case 0:
					exit = true;
					System.out.println("Exited successfully");
					break;
				default:
					System.out.println("Wrong Choice");
					break;
				}
			}
		}
	}

}
