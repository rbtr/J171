import java.util.Scanner;

class DateCheck {
	private static final int[] longMonths = new int[] {1,3,5,7,8,10,12};
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.print("Enter year: ");
			int year = scanner.nextInt();
			System.out.print("Enter month: ");
			int month = scanner.nextInt();
			System.out.print("Enter day: ");
			int day = scanner.nextInt();

			if (month > 12 || day > 31 || month < 1 || day < 1) {
				System.out.println("Date invalid");
				return;
			}

			checkDate(year, month, day);
		}
	}

	public static void checkDate(int year, int month, int day) {
		for (int i : longMonths) {
			if (month == i) {
				if (day <= 31) {
					System.out.println("Valid date.");
					return;
				}
			}
		}
		if (month == 2) {
			if (year % 4 == 0) {
				if (day <= 29) {
					System.out.println("Valid date.");
					return;
				} else  if (day <= 28) {
					System.out.println("Valid date.");
					return;
				}
			}
		}
		// Fell through all of the above, final check:
		if (day <= 30) {
			System.out.println("Valid date.");
			return; 
		}
		// INVALID DATE
		System.out.println("Invalid date.");
		return;
	}
}