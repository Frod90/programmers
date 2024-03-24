import java.util.ArrayList;
import java.util.List;

public class Shiritori {

	public int[] solution(int n, String[] words) {

		List<String> usedWords = new ArrayList<>();
		usedWords.add(words[0]);

		int count = 1;

		for (int i = 1; i < words.length; i++) {

			String beforeWord = words[i - 1];
			String currentWord = words[i];

			if(beforeWord.charAt(beforeWord.length() - 1) != currentWord.charAt(0)) {
				break;
			}

			if(usedWords.contains(currentWord)) {
				break;
			}

			System.out.println(usedWords);

			usedWords.add(currentWord);

			count++;
		}

		if(count == words.length) {
			return new int[] {0, 0};
		}

		return new int[] {count % n, count / n};
	}
}
