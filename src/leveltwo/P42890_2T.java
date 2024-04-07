package leveltwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P42890_2T {

	public int solution(String[][] relation) {

		List<String> answers = new ArrayList<>();

		for (int i = 1; i <= relation[0].length; i++) {
			makeIndexs(relation[0].length, i, 0, "");
		}

		for (String string : indexsResult) {

			int[] index = Arrays.stream(string.split(""))
				.map(Integer::parseInt)
				.mapToInt(i -> i)
				.toArray();

			Set<String> keyResult = new HashSet<>();

			for (int i = 0; i < relation.length; i++) {
				StringBuilder builder = new StringBuilder();

				for (int eachIndex : index) {
					builder.append(relation[i][eachIndex - 1]);
				}

				keyResult.add(builder.toString());
			}

			if (keyResult.size() == relation.length) {
				answers.add(string);
			}
		}

		List<String> trimAnswers = new ArrayList<>(answers);

		for (int i = 0; i < answers.size(); i++) {
			String[] splitedAnswer = answers.get(i).split("");
			for (int j = 0; j < answers.size(); j++) {
				if (i == j) {
					continue;
				}

				boolean mathSign = true;
				for (String eachSplit : splitedAnswer) {

					if (!answers.get(j).contains(eachSplit)) {
						mathSign = false;
						break;
					}
				}

				if (mathSign) {
					trimAnswers.remove(answers.get(j));
				}
			}
		}

		return trimAnswers.size();
	}

	List<String> indexsResult = new ArrayList<>();

	private void makeIndexs(int columnSize, int indexCount, int nextIndex, String indexs) {

		if (indexCount == indexs.length()) {
			indexsResult.add(indexs);
			return;
		}

		for (int i = nextIndex + 1; i <= columnSize; i++) {
			makeIndexs(columnSize, indexCount, i, indexs + i);
		}
	}

	public static void main(String[] args) {

		P42890_2T p428902T = new P42890_2T();
		int answer = p428902T.solution(new String[][] {{"a", "1", "aaa", "c", "ng"},
			{"a", "1", "bbb", "e", "g"},
			{"c", "1", "aaa", "d", "ng"},
			{"d", "2", "bbb", "d", "ng"}});
		System.out.println(answer);

	}
}

