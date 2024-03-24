public class Trio {
	public int solution(int[] number) {
		int answer = 0;

		for (int i = 0; i < number.length; i++) {
			int a = number[i];

			for (int j = 0; j < number.length; j++) {

				if (i == j) {
					continue;
				}

				int b = number[j];

				for (int k = 0; k < number.length; k++) {

					if (k == i || k == j) {
						continue;
					}

					int c = number[k];

					if (a + b + c == 0) {
						answer++;
					}
				}
			}
		}

		return answer;
	}

	public int solution2(int[] number) {
		int answer = 0;

		for (int i = 0; i < number.length - 2; i++) {
			for (int j = i + 1; j < number.length - 1; j++) {
				for (int k = j + 1; k < number.length; k++) {
					if (number[i] + number[j] + number[k] == 0)
						answer++;
				}
			}
		}

		return answer;
	}
}
