import java.util.Scanner;

public class Lab01_OOP_66_AddTwoMatrices {

	public static void main(String[] args) {
		// Add two matrices of size m x n
		int m = -1;
		int n = -1;
		System.out.print("Please input matrix size ");
		System.out.println(" (for example, '3 4' means a 3 x 4 matrix):");
		Scanner reader = new Scanner(System.in);
		m = reader.nextInt();
		n = reader.nextInt();
		
		int[][] A = new int[m][n];
		int[][] B = new int[m][n];
		int input;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print("A[" + i + "][" + j + "] = ");
				input = reader.nextInt();
				A[i][j] = input;
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print("B[" + i + "][" + j + "] = ");
				input = reader.nextInt();
				B[i][j] = input;
			}
		}
		
		int[][] C = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++)
				C[i][j] = A[i][j] + B[i][j];
		}
		
		System.out.println("A + B = ");
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(C[i][j] + " ");
			System.out.print("\n");
		}
		reader.close();
		
	}
	
	

}
