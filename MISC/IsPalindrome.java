
class IsPalindrome {
	public static void main(String[] args) {
		String test = args[0];
		System.out.println(isPalindrome(test));
	}

	private static boolean isPalindrome(String word) {
		int len = word.length() - 1;
		for (int i = 0; i <= len / 2; i++) {
			if (word.charAt(i) != word.charAt(len - i)) {
				return false;
			}
		}
		return true;
	}
}