package levelone;

import java.util.List;

public class Babbling {
	public int solution(String[] babbling) {
		int answer = 0;

		for (String eachBabbling : babbling) {
			if (isPossible(eachBabbling)) {
				answer++;
			}
		}

		return answer;
	}

	private boolean isPossible(String eachBabbling) {

		List<String> possibleBabbling = List.of("aya", "ye", "woo", "ma");

		for (String eachPossibleBalling : possibleBabbling) {

			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append(eachPossibleBalling).append(eachPossibleBalling);

			if (eachBabbling.contains(stringBuilder)) {
				return false;
			}

			eachBabbling = eachBabbling.replace(eachPossibleBalling, " ");

		}

		eachBabbling = eachBabbling.replace(" ", "");

		// 예시: "yayae" 이런 경우 바로 비어 있는 것으로 바꿔버리면 단어로 인식하게 됩니다~이런 것을 방지하기 위해 " " 했다가 ""으로 바꾸는 것으로 보입니다.

		return eachBabbling.isEmpty();
	}

}
