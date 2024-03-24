public class P60057 {
	public int solution(String s) {

		int answer = s.length();

		for(int i = 1; i < s.length() / 2; i++) {
			answer = Math.min(answer, calculate(s, i));
		}

		return answer;
	}

	private int calculate(String s, int unit) {

		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {

			int count = 1;

			String substringed;
			String nextSubstringed;

			if (i + unit <= s.length()) {
				substringed = s.substring(i, i + unit);

				do {

					if (i + unit * (count + 1) > s.length()) {
						break;
					}

					nextSubstringed = s.substring(i + unit * count, i + unit * (count + 1));

					if (substringed.equals(nextSubstringed)) {
						++count;
					}

				} while (substringed.equals(nextSubstringed));

				if (count > 1) {
					stringBuilder.append(count).append(substringed);
					i = i + unit * count - 1;

					continue;
				}

				stringBuilder.append(s.charAt(i));
			}
			System.out.print(i);
		}

		System.out.println(stringBuilder);

		return stringBuilder.length();
	}
}
