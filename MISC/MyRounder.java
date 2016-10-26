
import java.util.Scanner;

class MyRounder {
	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		while (true) {
			loop();
		}
	}

	public static void loop() {
		System.out.print(":>");

		double input = scanner.nextDouble();
		

		System.out.print("\n");
		
		print(round(input));
	}

	public static double round(double d) {
		return (Math.round(d * 2)) / 2d;
	}

	public static void print(double d) {
		System.out.println(String.valueOf(d));
	}
}