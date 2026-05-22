import java.util.Scanner;

public class Lab01OOP64_DaysInAMonth {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int month = -1;
        int year = -1;

        while (true) {
            System.out.println("Enter a month (Full name, Abbreviation, 3 letters, or Number): ");
            String monthInput = scanner.nextLine();
            month = parseMonth(monthInput);

            System.out.println("Enter a year (non-negative number, all digits): ");
            String yearInput = scanner.nextLine();
            year = parseYear(yearInput);

            if (month != -1 && year != -1) {
                int days = getDaysInMonth(month, year);
                System.out.println("The number of days in " + monthInput + " " + year + " is: " + days);
                break;
            } else {
                System.out.println("Invalid month or year. Please try again.\n");
            }
        }
        scanner.close();
    }

    // Convert month input to a number (1-12)
    private static int parseMonth(String input) {
        String lower = input.toLowerCase();
        
        switch (lower) {
            case "january": case "jan.": case "jan": case "1": return 1;
            case "february": case "feb.": case "feb": case "2": return 2;
            case "march": case "mar.": case "mar": case "3": return 3;
            case "april": case "apr.": case "apr": case "4": return 4;
            case "may": case "5": return 5;
            case "june": case "jun.": case "jun": case "6": return 6;
            case "july": case "jul.": case "jul": case "7": return 7;
            case "august": case "aug.": case "aug": case "8": return 8;
            case "september": case "sept.": case "sep": case "9": return 9;
            case "october": case "oct.": case "oct": case "10": return 10;
            case "november": case "nov.": case "nov": case "11": return 11;
            case "december": case "dec.": case "dec": case "12": return 12;
            default: return -1;
        }
    }

    private static int parseYear(String input) {
    	return Integer.parseInt(input);
    }

    private static int getDaysInMonth(int month, int year) {
        switch (month) {
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    return 29;
                } else {
                    return 28;
                }
            default:
                return 31;
        }
    }
}