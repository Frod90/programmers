public class NumberExpression {

	class Solution {
		public int solution(int n) {

			int answer = 0;
			double maxIndex = (double)n / 2;

			for (int startIndex = 1; startIndex < maxIndex; startIndex++) {

				if (match(startIndex, n)) {
					answer++;
				}
			}

			return ++answer;
		}
	}

	private boolean match(int startIndex, int n) {

		int number = 0;

		while (number < n) {
			number += startIndex;
			startIndex++;
		}

		return number == n;

	}
}
