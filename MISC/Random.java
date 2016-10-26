
class Random {
	public static void main(String[] args) {
		if (args != null) {
			int[] vals = new int[args.length];
			for (int i = 0; i < args.length; i++) {
				vals[i] = Integer.parseInt(args[i]);
			}	
			System.out.println("" + getRandom(vals));
		}	
	}

	public static int getRandom(int[] vals) {
		int low = vals[0];
		int high = vals[vals.length - 1];

		if (high - low <= vals.length - 1) {
			throw new IllegalStateException("No values left...");
		}

		return generateRandomNotInList(vals, low, high);
	}

	public static int generateRandomNotInList(int[] list, int low, int high) {
		int rand = list[0];
		
		rand = low + (int) Math.round((high - low) * Math.random());

		for (int i : list) {
			if (i == rand) {
				rand = generateRandomNotInList(list, low, high);
			}
		}

		return rand;
	}
}