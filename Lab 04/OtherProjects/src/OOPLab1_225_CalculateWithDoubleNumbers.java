import java.util.Scanner;

public class OOPLab1_225_CalculateWithDoubleNumbers {

	public static void main(String[] args) {
		System.out.println("Please input two real numbers separated by an empty space:");
		
		Scanner reader = new Scanner(System.in);
		String input = reader.nextLine();
		
		String[] floatStrings = input.trim().split(" ");
		
		if (floatStrings.length < 2) {
			System.out.println("You didn't enter two numbers.");
			reader.close();
			return;
		}
		
		double num1 = Double.parseDouble(floatStrings[0]);
		double num2 = Double.parseDouble(floatStrings[1]);
		
		System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
		System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
		System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
		if (num2 == 0.0)
			System.out.println("The second number (the divisor) is 0. Can't perform the division.");
		else
			System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
		
		reader.close();
		System.exit(0);
		
	}

}
