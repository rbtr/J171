import java.util.*;

class LeastPlateRounding {
	private static final double[] availablePlates = new double[] {45, 25, 10, 5, 2.5};
	private static double barWeight = 45;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.print("Enter a raw weight: ");
			double raw = scanner.nextDouble();

			System.out.println("Rounded to nearest lower plate: " + roundLeastPlates(raw, availablePlates, barWeight));
		}
	}

	private static double roundLeastPlates(double weight, double[] availablePlates, double barWeight) {
        double onBar = weight - barWeight;
        double perSide = onBar / 2;

        double platesWeight = 2 * addPlate(perSide, 0, availablePlates);
        return platesWeight + barWeight;
    }

    private static double addPlate(double weight, double total, double[] availablePlates) {
        for (double availablePlate : availablePlates) {
            if (availablePlate <= weight) {
            	printPlate(availablePlate);
                total = addPlate(weight - availablePlate, total, availablePlates);
                total += availablePlate;
                return total;
            }
        }
        return total;
    }

	private static void printPlate(double d) {
		System.out.println(d + " x 2 = " + (d * 2));
	}
}