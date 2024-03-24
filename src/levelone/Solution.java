package levelone;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
	public int[] solution(String[] keymap, String[] targets) {

		int[] answer = new int[targets.length];

		for (int i = 0; i < targets.length; i++) {

			String eachTarget = targets[i];
			int count = 0;

			for (int j = 0; j < eachTarget.length(); j++) {
				String findingLetter = eachTarget.charAt(j) + "";

				int minIndex = findMinIndex(findingLetter, keymap);

				if (minIndex == -1) {
					count = -1;
					break;
				}

				count += minIndex;
			}

			answer[i] = count;
		}

		return answer;
	}

	public int findMinIndex(String findingLetter, String[] keymap) {

		List<String> filteredKeymap = Arrays.stream(keymap)
			.filter(i -> i.contains(findingLetter))
			.collect(Collectors.toList());

		if (filteredKeymap.isEmpty()) {
			return -1;
		}

		List<Integer> answers = filteredKeymap.stream()
			.map(i -> i.indexOf(findingLetter))
			.collect(Collectors.toList());

		int index = answers.get(0);

		for (int i = 1; i < answers.size(); i++) {

			index = Math.min(index, answers.get(i));

		}

		return index + 1;

	}

}


