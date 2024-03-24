package levelone;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumber {

	public int solution(int n) {

		List<Integer> primeNums = new ArrayList<>();

		for (int i = 2; i <= n; i++) {

			int count = 0;
			double limit = Math.sqrt(i);

			for (int j = 2; j <= limit; j++) {

				if (i % j == 0) {
					count++;
					break;
				}

			}

			if (count == 0) {
				primeNums.add(i);
			}
		}

		return primeNums.size();
	}
}
