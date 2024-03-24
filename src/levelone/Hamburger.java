package levelone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Hamburger {

	public int solution(int[] ingredient) {

		int answer = 0;

		List<Integer> source = Arrays.stream(ingredient)
			.boxed()
			.collect(Collectors.toList());

		while (isMade(source)) {
			answer++;
		}

		return answer;
	}

	private boolean isMade(List<Integer> source) {

		for (int i = 0; i < source.size() - 3; i++) {

			if (source.get(i) == 1
				&& source.get(i + 1) == 2
				&& source.get(i + 2) == 3
				&& source.get(i + 3) == 1) {

				for (int j = 0; j < 4; j++) {
					source.remove(i);
				}

				return true;
			}
		}

		return false;
	}

}
