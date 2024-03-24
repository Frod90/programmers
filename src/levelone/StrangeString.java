package levelone;

public class StrangeString {

	public String solution(String s) {

		String[] splitWord = s.split(" ", -1);

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(convertWord(splitWord[0].trim()));

		for (int i = 1; i < splitWord.length; i++) {
			stringBuilder.append(" ").append(convertWord(splitWord[i].trim()));
		}

		return stringBuilder.toString();
	}

	private String convertWord(String word) {

		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < word.length(); i++) {

			String ch = word.charAt(i) + "";

			if (i % 2 == 0) {
				stringBuilder.append(ch.toUpperCase());
				continue;
			}

			stringBuilder.append(ch.toLowerCase());

		}

		return stringBuilder.toString();
	}
}
