package leveltwo;

import java.util.ArrayList;
import java.util.List;

public class P60057_2T {
	public int solution(String s) {

		int answer = s.length();

		for(int i = 1; i <= s.length() / 2; i++) {
			answer = Math.min(answer, calculate(s, i));
		}

		return answer;
	}

	private int calculate(String s, int unit) {


		StringBuilder stringBuilder = new StringBuilder();

		List<String> dividedS = new ArrayList<>();

		for (int i = 0; i < s.length() / unit; i++) {

			String substringed = s.substring(i * unit, (i + 1) * unit);
			dividedS.add(substringed);
		}

		for (int i = 0; i < dividedS.size(); i++) {
			int count = 1;

			String s1 = dividedS.get(i);
			String nextS1;

			do {
				if (i + count >= dividedS.size()) {
					break;
				}
				nextS1 = dividedS.get(i + count);

				if (s1.equals(nextS1)) {
					count++;
				}
			} while (s1.equals(nextS1));

			if (count > 1) {
				stringBuilder.append(count).append(s1);
				i = i + count - 1;
			} else {
				stringBuilder.append(s1);
			}

		}

		if (s.length() % unit != 0) {

			int restCount = s.length() % unit;

			String rest = s.substring(s.length() - restCount);
			stringBuilder.append(rest);
		}

		return stringBuilder.length();
	}
}
