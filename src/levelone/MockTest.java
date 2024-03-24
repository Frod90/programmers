package levelone;

import java.util.ArrayList;
import java.util.List;

public class MockTest {
	public int[] solution(int[] answers) {

		int correction1 = 0;
		int correction2 = 0;
		int correction3 = 0;

		for (int i = 1; i <= answers.length; i++) {

			int submission1 = makeSubmission1(i);
			int submission2 = makeSubmission2(i);
			int submission3 = makeSubmission3(i);

			if (answers[i - 1] == submission1) {
				correction1++;
			}

			if (answers[i - 1] == submission2) {
				correction2++;
			}

			if (answers[i - 1] == submission3) {
				correction3++;
			}

		}

		int max = Math.max(correction1, correction2);
		max = Math.max(max, correction3);

		List<Integer> answer = new ArrayList<>();

		if (max == correction1) {
			answer.add(1);
		}

		if (max == correction2) {
			answer.add(2);
		}

		if (max == correction3) {
			answer.add(3);
		}

		int answerSize = answer.size();

		return answer.stream().mapToInt(i -> i).toArray();
	}

	private int makeSubmission1(int i) {

		int sign = i % 5;

		if (sign == 0) {
			return 5;
		}

		return sign;
	}

	private int makeSubmission2(int i) {

		if (i % 2 != 0) {
			return 2;
		}

		int sign = (i / 2) % 4;

		return switch (sign) {
			case 1 -> 1;
			case 2 -> 3;
			case 3 -> 4;
			case 0 -> 5;
			default -> 0;
		};

	}

	private int makeSubmission3(int i) {

		int sign = i % 10;

		return switch (sign) {
			case 1, 2 -> 3;
			case 3, 4 -> 1;
			case 5, 6 -> 2;
			case 7, 8 -> 4;
			case 9, 0 -> 5;
			default -> 0;
		};

	}

}
