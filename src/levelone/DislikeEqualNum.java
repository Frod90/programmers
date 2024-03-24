package levelone;

import java.util.ArrayList;
import java.util.List;

public class DislikeEqualNum {

	public int[] solution(int[] arr) {

		List<Integer> answer = new ArrayList<>();

		answer.add(arr[0]);

		for (int i = 1; i < arr.length; i++) {

			if (arr[i] == arr[i - 1]) {
				continue;
			}

			answer.add(arr[i]);

		}

		return answer.stream().mapToInt(i -> i).toArray();

	}
}
