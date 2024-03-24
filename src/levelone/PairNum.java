package levelone;

import java.util.HashMap;
import java.util.Map;

public class PairNum {
	public String solution(String X, String Y) {
		StringBuilder answer = new StringBuilder();

		Map<Integer, Integer> x = countNum(X);
		Map<Integer, Integer> y = countNum(Y);

		System.out.println(x);
		System.out.println(y);

		for (int i = 9; i >= 0; i--) {

			int count = Math.min(x.getOrDefault(i, 0), y.getOrDefault(i, 0));

			answer.append(String.valueOf(i).repeat(count));
		}

		if (answer.toString().isEmpty()) {
			return "-1";
		} else if (answer.toString().charAt(0) == '0') {
			return "0";
		}

		return answer.toString();
	}

	private Map<Integer, Integer> countNum(String num) {

		Map<Integer, Integer> countedNum = new HashMap<>();

		for (int i = 0; i < num.length(); i++) {

			int eachCountedNum = Integer.parseInt(num.charAt(i) + "");

			countedNum.put(eachCountedNum, countedNum.getOrDefault(eachCountedNum, 0) + 1);
		}

		return countedNum;
	}
}
