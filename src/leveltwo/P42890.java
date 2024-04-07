package leveltwo;

import java.util.HashSet;
import java.util.Set;

public class P42890 {

	public int solution(String[][] relation) {

		isKey(relation, 1, 0);

		return answer;
	}

	int answer = 0;

	private boolean isKey(String[][] relation, int count, int startIndex) {

		if (relation[0].length >= count) {
			return false;
		}

		if (relation[0].length <= count + startIndex - 1) {
			return isKey(relation, count + 1, 0);
		}

		Set<String> keys = new HashSet<>();

		for (int i = 0; i < relation.length; i++) {

			String input = "";
			StringBuilder builder = new StringBuilder();

			for (int j = startIndex; j < startIndex + count - 1; j++) {
				builder.append(relation[i][j]);
			}

			keys.add(builder.toString());
		}

		if (keys.size() == relation.length) {
			answer++;
		}

		return isKey(relation, count, startIndex + 1);

	}

	public static void main(String[] args) {

		int n = 5;
		Set<String> set = new HashSet<>();




	}
}

