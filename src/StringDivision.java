public class StringDivision {
	public int solution(String s) {

		int answer = 0;
		int matchCount = 1;
		int MismatchCount = 0;
		char standardLetter = s.charAt(0);

		for (int i = 1; i < s.length(); i++) {

			if (matchCount == MismatchCount) {
				answer++;
				matchCount = 1;
				MismatchCount = 0;
				standardLetter = s.charAt(i);
				continue;
			}

			if (standardLetter == s.charAt(i)) {
				matchCount++;
				continue;
			}

			MismatchCount++;
		}

		return ++answer;
	}

}
