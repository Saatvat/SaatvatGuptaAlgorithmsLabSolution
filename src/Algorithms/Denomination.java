package Algorithms;
import java.util.Scanner;

public class Denomination {

	int amount;

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
	
	static int[] denoms(int [] array, Denomination obj) {
		int [] vals = new int [array.length];
		for (int i = 0; i < array.length; i++) {
			if (obj.amount >= array[i]) {
				vals[i] = obj.amount / array[i];
				obj.amount -= vals[i] * array[i];
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
		Denomination obj = new Denomination();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of currency denominations: ");
		int num = sc.nextInt();
		
		while (num == 0) {
			System.out.println("This payment can't happen, enter again: ");
			num = sc.nextInt();
		}
		
		System.out.println("Enter the currency denominations value ");
		int [] arr = new int[num];
		for (int i = 0; i < num; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.print("\n");
		sort(arr);
		
		System.out.println("Enter the amount you want to pay: ");
		obj.amount = sc.nextInt();
		sc.close();
		System.out.print("\n");
		
		int [] values = denoms(arr, obj);
		if (obj.amount == 0) {
			System.out.println("Your payment approach in order to give min no of notes will be: ");
			for (int i = 0; i < num; i++)
				System.out.println(arr[i] + " : " + values[i]);
		}
		else {
			System.out.println("This amount can't be paid in the given denomination.");
		}
	}
}
