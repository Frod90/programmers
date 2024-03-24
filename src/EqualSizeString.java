public class EqualSizeString {

	public int solution(String t, String p) {

		int answer = 0;

		for (int i = 0; i <= t.length() - p.length(); i++) {
			long comparedNum = Long.parseLong(t.substring(i, i + p.length()));

			if (comparedNum <= Long.parseLong(p)) {
				answer++;
			}
		}

		return answer;
	}

}
