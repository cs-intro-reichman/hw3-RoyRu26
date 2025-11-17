// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
		// Tests some of the operations
		// System.out.println(plus(0, 3)); // 2 + 3
		// System.out.println(minus(-3, 4)); // 7 - 2
		// System.out.println(minus(2, 7)); // 2 - 7
		// System.out.println(times(3, 5)); // 3 * 4
		// System.out.println(plus(2, times(4, 2))); // 2 + 4 * 2
		// System.out.println(pow(5, 3)); // 5^3
		// System.out.println(pow(3, 5)); // 3^5
		 System.out.println(div(12, 3)); // 12 / 3
		 System.out.println(div(0, 5)); // 5 / 5
		 System.out.println(div(-25, -5)); // 25 / 7
		// System.out.println(mod(25, 7)); // 25 % 7
		// System.out.println(mod(120, 6)); // 120 % 6
		// System.out.println(sqrt(36));
		// System.out.println(sqrt(1));
		// System.out.println(sqrt(76123));
	}

	public static int plus(int x1, int x2) {
		int res = x1;
		if (x2 > 0) {
			for (int i = x2; i > 0; i--) {
				res++;
			}
		} else {
			for (int i = x2; i < 0; i++) {
				res--;
			}
		}
		return res;
	}

	public static int minus(int x1, int x2) {
		int res = x1;
		if (x2 > 0) {
			for (int i = x2; i > 0; i--) {
				res--;
			}
		} else {
			for (int i = x2; i < 0; i++) {
				res++;
			}
		}
		return res;
	}

	public static int times(int x1, int x2) {
		int res = 0;
		if (x2 > 0) {
			for (int i = 0; i < x2; i++) {
				res = plus(res, x1);
			}
		} else {
			for (int i = x2; i < 0; i++) {
				res = minus(res, x1);
			}
		}
		return res;
	}

	public static int pow(int x, int n) {
		int res = 1;
		if (x == 0) {
			return 0;
		}
		for (int i = 0; i < n; i++) {
			res = times(res, x);
		}
		return res;
	}

	public static int div(int x1, int x2) {
		int res = 0;
		if(x1 == 0){
			return 0;
		}
		if ((x1 > 0 && x2 > 0) || (x1 < 0 && x2 < 0)) {
			if (x1 < 0) {
				x1 = times(x1, -1);
				x2 = times(x2, -1);
			}
			while (minus(x1, x2) >= 0) {
				x1 = minus(x1, x2);
				res++;
			}
		} else {
			if (x1 < 0) {
				x1 = times(x1, -1);
			} else {
				x2 = times(x2, -1);
			}
			while (minus(x1, x2) >= 0) {
				x1 = minus(x1, x2);
				res--;
			}
		}
		return res;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int res = 0;
		if(x1 == 0){
			return 0;
		}
		res = minus(x1, times(div(x1, x2), x2));
		return res;
	}

	// Returns the integer part of sqrt(x)
	public static int sqrt(int x) {
		int left = 1, right = x / 2;
		int res = 0;
		if (x == 1) {
			return 1;
		}
		while (left <= right) {
			int mid = left + (right - left) / 2;
			double sq = (double) mid * mid;
			if (sq == x) {
				return mid;
			}
			if (sq < x) {
				res = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return res;
	}
}