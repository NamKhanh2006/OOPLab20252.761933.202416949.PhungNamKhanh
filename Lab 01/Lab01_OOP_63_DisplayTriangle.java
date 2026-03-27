import java.util.Scanner;

public class Lab01_OOP_63_DisplayTriangle {

	public static void main(String[] args) {
		int n = -1;
		System.out.println("Please input the height n of the triangle:");
		Scanner reader = new Scanner(System.in);
		n = reader.nextInt();
		
		if (n <= 0) {
			System.out.println("Invalid value for height n!");
			return;
		}
		
		for (int i = 1; i <= n; i++) {
			int numSpace = n - i;
			for (int j = 1; j <= numSpace; j++)
				System.out.print(" ");
			for (int j = 1; j <= 2 * i - 1; j++)
				System.out.print("*");
			for (int j = 1; j <= numSpace; j++)
				System.out.print(" ");
			System.out.print("\n");
		}

	}

}
