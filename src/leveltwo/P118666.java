package leveltwo;

public class P118666 {

	public String solution(String[] survey, int[] choices) {
		String answer = "";

		int[] scores = new int[4];

		for (int i = 0; i < choices.length; i++) {
			String category = survey[i];

			if (category.contains("T")) {
				scores[0] = scores[0] + calculate(category, choices[i]);
			} else if (category.contains("F")) {
				scores[1] = scores[1] + calculate(category, choices[i]);
			} else if (category.contains("M")) {
				scores[2] = scores[2] + calculate(category, choices[i]);
			} else if (category.contains("N")) {
				scores[3] = scores[3] + calculate(category, choices[i]);
			}
		}

		if (scores[0] > 0) {
			answer += "T";
		} else {
			answer += "R";
		}

		if (scores[1] > 0) {
			answer += "F";
		} else {
			answer += "C";
		}

		if (scores[2] > 0) {
			answer += "M";
		} else {
			answer += "J";
		}

		if (scores[3] > 0) {
			answer += "N";
		} else {
			answer += "A";
		}

		return answer;
	}

	private int calculate(String survey, int choice) {

		int score = choice - 4;

		char ch = survey.charAt(0);

		if (ch == 'T' || ch == 'F' || ch == 'M' || ch == 'N') {
			return -score;
		}

		return score;
	}
}
