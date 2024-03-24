package leveltwo;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

	public int solution(int n) {

		final int DIVISION_UNIT = 1234567;

		Map<String, Integer> fi = new HashMap<>();
		fi.put("n-2", 0);
		fi.put("n-1", 1);

		int result = 0;

		for(int i = 2; i <= n; i++) {
			int num1 = fi.get("n-2");
			int num2 = fi.get("n-1");

			result = (num1 + num2) % DIVISION_UNIT;

			fi.replace("n-2", num2);
			fi.replace("n-1", result);

		}

		return result;

	}
}
