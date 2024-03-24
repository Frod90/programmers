import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NearestLetter {

	public int[] solution(String s) {

		List<Integer> answer = new ArrayList<>();

		for (int i = 0; i < s.length(); i++) {

			char standardLetter = s.charAt(i);

			answer.add(findComparedLetterIndex(s, i, standardLetter));
		}

		return answer.stream().mapToInt(i -> i).toArray();
	}

	private int findComparedLetterIndex(String s, int i, char standardLetter) {

		int comparedLetterIndex = -1;

		for (int j = 0; j < i; j++) {

			if (standardLetter == s.charAt(j)) {
				comparedLetterIndex = j;
			}
		}

		if (comparedLetterIndex == -1) {
			return comparedLetterIndex;
		}

		return i - comparedLetterIndex;
	}

	public int[] solution2(String s) {

		Map<Character, Integer> comparedTable = new HashMap<>();

		List<Integer> answer = new ArrayList<>();

		for (int i = 0; i < s.length(); i++) {

			char standardLetter = s.charAt(i);

			int comparedLetterIndex = comparedTable.getOrDefault(standardLetter, i + 1);

			answer.add(i - comparedLetterIndex);
			comparedTable.put(standardLetter, i);
		}

		return answer.stream().mapToInt(i -> i).toArray();
	}

}
