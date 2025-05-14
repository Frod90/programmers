package leveltwo;

import java.util.ArrayList;
import java.util.List;

public class P134239 {

	public double[] solution(int k, int[][] ranges) {

		List<Integer> list = new ArrayList<>();
		list.add(k);

		while (k != 1) {

			if (k % 2 == 0) {
				k = k / 2;
			} else {
				k = k * 3 + 1;
			}

			list.add(k);
		}

		double[] areas = new double[list.size() - 1];

		for (int i = 0; i < areas.length; i++) {
			int a = list.get(i);
			int b = list.get(i + 1);
			areas[i] = Math.min(a, b) + Math.abs(a - b) / 2.0;
		}

		double[] answers = new double[ranges.length];

		int n = areas.length;
		for (int i = 0; i < ranges.length; i++) {
			int a = ranges[i][0];
			int b = ranges[i][1];

			double answer = 0.0;
			if (a <= n + b) {
				for (int j = a; j < n + b; j++) {
					answer += areas[j];
				}
			} else {
				answer = -1.0;
			}

			answers[i] = answer;
		}

		return answers;
	}
}
