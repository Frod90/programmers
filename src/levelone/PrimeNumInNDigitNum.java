package levelone;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrimeNumInNDigitNum {

	public int solution(int n, int k) {

		String pattern = "^[0-9]*$";

		String kDigit = Integer.toString(n, k);

		List<Long> nums = Arrays.stream(kDigit.split("0"))
			.filter(i -> !i.isBlank())
			.filter(i -> i.matches(pattern))
			.filter(i -> !i.equals("0") && !i.equals("1"))
			.map(Long::parseLong)
			.filter(this::isPrimeNum)
			.collect(Collectors.toList());

		return nums.size();
	}

	public boolean isPrimeNum(long num) {

		double limit = Math.sqrt(num);

		for (int i = 2; i <= limit; i++) {

			if (num % i == 0) {
				return false;
			}
		}

		return true;
	}
}
