package Algorithms;
import java.util.Scanner;

public class Transaction {
	
	public static int transaction(int [] array, int target) {
		int count = 0, i = 0, status = 0;

		while (target >= count) {
			if (i > array.length - 1) {
				status = 0;
				break;
			}
			count += array[i++];
			status = i;
		}
		return status;
	}
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the size of transaction array:");
		int num = sc.nextInt();
		
		int [] arr = new int[num];
		System.out.println("Enter the values of array: ");
		for (int i = 0; i < num; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println("Enter the total no of targets that needs to be achieved: ");
		int targets = sc.nextInt();
		
		for (int i = 0; i < targets; i++) {
			System.out.println("Enter the value of target: ");
			int target = sc.nextInt();
			sc.close();
			
			int end = transaction(arr, target);
			if (end == 0) {
				System.out.println("Given target is not achieved.");
			}
			else 
				System.out.println("Target achieved after " + end + " transactions");
		}
	}
}
