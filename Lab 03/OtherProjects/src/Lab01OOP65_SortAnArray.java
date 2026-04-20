import java.util.Scanner;

public class Lab01OOP65_SortAnArray {

	public static void main(String[] args) {
		int n = -1;
		System.out.println("Please input the number of elements in the array:");
		Scanner reader = new Scanner(System.in);
		n = reader.nextInt();
		int[] A = new int[n];
		System.out.println("Please input the elements:");
		for (int i = 0; i < n; i++) {
			int k = reader.nextInt();
			A[i] = k;
		}
		
		int minIndex = 0;
		for (int i = 0; i < n; i++) {
			minIndex = i;
			for (int j = i; j < n; j++) {
				if (A[j] < A[minIndex])
					minIndex = j;
			}
			int temp = A[i];
			A[i] = A[minIndex];
			A[minIndex] = temp;
		}
		
		int sum = 0;
		System.out.println("Sorted array:");
		for (int i = 0; i < n; i++) {
			System.out.print(A[i] + ", ");
			sum = sum + A[i];
		}
		System.out.println("\nSum of array elements: " + sum);
		double avg = ((double) sum) / ((double) n);
		System.out.println("Average value of array elements: " + avg);
		reader.close();
	}

}
