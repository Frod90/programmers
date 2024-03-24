package levelone;

import java.util.Stack;

public class Hamburger2 {

	public int solution(int[] ingredient) {
		int answer = 0;

		Stack<Integer> source = new Stack<>();

		for (int eachIngredient : ingredient) {

			source.push(eachIngredient);

			if (source.size() >= 4
				&& source.get(source.size() - 1) == 1
				&& source.get(source.size() - 2) == 3
				&& source.get(source.size() - 3) == 2
				&& source.get(source.size() - 4) == 1) {

				answer++;

				for (int i = 0; i < 4; i++) {
					source.pop();
				}
			}
		}

		return answer;
	}
}
