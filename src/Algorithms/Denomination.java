package Algorithms;
import java.util.Scanner;

public class Denomination {

	public static void sort(int [] array) {
		int len = array.length;
		while (len > 0) {
			for (int i = 1; i < len; i++) {
				if (array[i] > array[i - 1])
					swap(array, i - 1, i);
			}
			len--;
		}
	}
	
	public static int[] denoms(int [] array, int amount) {
		int [] vals = new int [array.length];
		for (int i = 0; i < array.length; i++) {
			if (amount >= array[i]) {
				vals[i] = amount / array[i];
				amount -= vals[i] * array[i];
			}
		}
		return vals;
	}
	
	public static void swap (int [] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of currency denominations: ");
		int num = sc.nextInt();
		
		System.out.println("Enter the currency denominations value ");
		int [] arr = new int[num];
		for (int i = 0; i < num; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.print("\n");
		sort(arr);
		
		System.out.println("Enter the amount you want to pay: ");
		int amount = sc.nextInt();
		sc.close();
		System.out.print("\n");
		
		int [] values = denoms(arr, amount);
		if (amount != 0) {
			System.out.println("This amount can't be paid in the given denomination.");
		}
		else {
			System.out.println("Your payment approach in order to give min no of notes will be: ");
			for (int i = 0; i < num; i++)
				System.out.println(arr[i] + " : " + values[i]);
		}
	}
}
