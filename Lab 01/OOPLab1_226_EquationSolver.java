import java.util.Scanner;
import java.lang.Math;

public class EquationSolver {

	public static void main(String[] args) {
		System.out.println("Please choose one mode:");
		System.out.println("1. ax + b = 0");
		System.out.println("2. a11x1 + a12x2 = b1");
		System.out.println("   a21x1 + a22x2 = b2");
		System.out.println("3. ax^2 + bx + c = 0");
		
		Scanner reader = new Scanner(System.in);
		int choice = reader.nextInt();
		switch (choice) {
			case 1:
				solveFirstDegree(reader);
				break;
			case 2:
				solveSystem(reader);
				break;
			case 3:
				solveSecondDegree(reader);
				break;
			default:
				System.out.println("Invalid choice!");
		}
		reader.close();
	}
	
	// First choice: First-degree equation with one variable
	public static void solveFirstDegree(Scanner reader) {
		System.out.print("a = ");
		double a = reader.nextDouble();
		System.out.print("b = ");
		double b = reader.nextDouble();
		
		if (a == 0.0) {
			if (b == 0.0)
				System.out.println("Infinite solutions.");
			else
				System.out.println("No solution.");
		}
		else
			System.out.println("x = " + (-b)/a);	
	}
	
	// Second choice: Set of two linear equations with two unknowns
	public static void solveSystem(Scanner reader) {
		System.out.print("a11 = ");
		double a11 = reader.nextDouble();
		System.out.print("a12 = ");
		double a12 = reader.nextDouble();
		System.out.print("b1 = ");
		double b1 = reader.nextDouble();
		System.out.print("a21 = ");
		double a21 = reader.nextDouble();
		System.out.print("a22 = ");
		double a22 = reader.nextDouble();
		System.out.print("b2 = ");
		double b2 = reader.nextDouble();
		
		double D = a11 * a22 - a12 * a21;
		double Dx = b1 * a22 - a12 * b2;
		double Dy = a11 * b2 - b1 * a21;
		
		if (D == 0.0) {
			if (Dx == 0.0 && Dy == 0.0) {
				if ((a11 == 0.0 && a12 == 0.0 && b1 != 0.0) || (a21 == 0.0 && a22 == 0.0 && b2 != 0.0))
					System.out.println("No solution.");
				else
					System.out.println("Infinite solutions.");
			}
			else
				System.out.println("No solution.");
		}
		else {
			System.out.println("x = " + Dx / D + ", y = " + Dy / D);
		}
	}
	
	// Third choice: Second-degree equation with one unknown
	public static void solveSecondDegree(Scanner reader) {
		System.out.print("a = ");
		double a = reader.nextDouble();
		System.out.print("b = ");
		double b = reader.nextDouble();
		System.out.print("c = ");
		double c = reader.nextDouble();
		
		if (a == 0.0) {
	        if (b == 0.0) {
	        	if (c == 0.0)
	        		System.out.println("Infinite solutions.");
	        	else
	        		System.out.println("No solution.");
	        } else {
	            System.out.println("x = " + (-c / b));
	        }
	        return;
	    }
		
		double delta = b * b - 4 * a * c;
		if (delta < 0.0)
			System.out.println("No root.");
		else if (delta == 0.0)
			System.out.println("Double root: x1 = x2 = " + -b / (2 * a));
		else {
			double sqrtDelta = Math.pow(delta, 0.5);
			double x1 = (-b + sqrtDelta) / (2 * a);
			double x2 = (-b - sqrtDelta) / (2 * a);
			System.out.println("x1 = " + x1 + ", x2 = " + x2);
		}
		
	}

}
