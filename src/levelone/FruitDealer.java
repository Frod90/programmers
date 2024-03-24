package levelone;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FruitDealer {

	public int solution(int k, int m, int[] score) {

		int answer = 0;

		List<Integer> appleScore = Arrays.stream(score)
			.boxed()
			.sorted()
			.collect(Collectors.toList());

		while (appleScore.size() >= m) {

			int p = k;

			for (int i = 0; i < m; i++) {
				p = Math.min(p, appleScore.remove(appleScore.size() - 1));
			}

			int boxScore = p * m;

			answer += boxScore;
		}

		return answer;
	}

	public int solution2(int k, int m, int[] score) {

		Map<Integer, Integer> appleScore = new HashMap<>();

		for (int eachScore : score) {
			appleScore.put(eachScore, appleScore.getOrDefault(eachScore, 0) + 1);
		}

		int answer = 0;
		return answer;
	}

}
