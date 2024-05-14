package levelone;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P258712 {

	public int solution(String[] friends, String[] gifts) {
		int answer = 0;

		List<String> names = Arrays.stream(friends).collect(Collectors.toList());

		int[][] details = new int[friends.length][friends.length];
		int[] giftIndexs = new int[friends.length];

		for (int i = 0; i < gifts.length; i++) {

			String[] split = gifts[i].split(" ");

			int n = names.indexOf(split[0].trim());
			int m = names.indexOf(split[1].trim());

			//System.out.println(n + " : " + m);

			details[n][m] += 1;
			giftIndexs[n] += 1;
			giftIndexs[m] -= 1;

		}

		int[] answers = new int[friends.length];

		for (int i = 0; i < details.length; i++) {
			for (int j = 0; j < details[i].length; j++) {

				if (details[i][j] > details[j][i]) {
					answers[i] += 1;
				} else if (details[i][j] == details[j][i]
					&& giftIndexs[i] > giftIndexs[j]) {
					answers[i] += 1;
				}
			}
		}

		int max = answers[0];

		for (int i = 1; i < answers.length; i++) {
			max = Math.max(max, answers[i]);
		}

		return max;
	}
}
