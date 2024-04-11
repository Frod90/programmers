package leveltwo;

import java.util.ArrayList;
import java.util.List;

public class P92342 {

	int[] hit = new int[11];
	List<int[]> answers = new ArrayList<>();

	public int[] solution(int n, int[] info) {

		makeHit(n, 0, info);

		int result = 0;
		int[] answer = null;

		for (int[] eachHit : answers) {

			int eachHitSum = 0;
			int eachInfoSum = 0;

			for (int i = 0; i < info.length - 1; i++) {

				if (eachHit[i] != 0 && eachHit[i] > info[i]) {
					eachHitSum = eachHitSum + 10 - i;
				} else if (info[i] != 0 && eachHit[i] <= info[i]) {
					eachInfoSum += (10 - i);
				}
			}

			// System.out.println(eachHitSum + " : " + eachInfoSum);

			int diff = eachHitSum - eachInfoSum;

			if (diff > 0) {

				if (diff > result) {
					result = diff;
					answer = eachHit;
				}

				if (diff == result && answer != null) {
					for (int i = eachHit.length - 1; i >= 0; i--) {

						if (eachHit[i] == answer[i]) {
							continue;
						}

						if (eachHit[i] > answer[i]) {
							answer = eachHit;
						}

						break;
					}
				}
			}
		}

		if (answer == null) {
			return new int[] {-1};
		}

		return answer;
	}

	private void makeHit(int n, int index, int[] info) {

		if (n <= 0 || index >= hit.length - 1) {
			// System.out.println(Arrays.toString(hit));
			hit[hit.length - 1] = n;
			answers.add(hit.clone());
			return;
		}

		if (n > info[index]) {
			hit[index] = info[index] + 1;
			makeHit(n - info[index] - 1, index + 1, info);
		}

		hit[index] = 0;
		makeHit(n, index + 1, info);

	}
}
