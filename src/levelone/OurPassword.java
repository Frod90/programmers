package levelone;

import java.util.ArrayList;
import java.util.List;

public class OurPassword {
	public String solution(String s, String skip, int index) {

		char[] splitSkip = skip.toCharArray();
		List<Integer> skipChar = toList(splitSkip);

		List<Integer> conversionTable = makeConversionTable(skipChar);

		char[] splitS = s.toCharArray();

		return convertS(splitS, conversionTable, index);
	}

	private List<Integer> toList(char[] splitSkip) {

		List<Integer> skipChar = new ArrayList<>();

		for (char eachChar : splitSkip) {
			skipChar.add((int)eachChar);
		}

		return skipChar;
	}

	private List<Integer> makeConversionTable(List<Integer> skipChar) {

		List<Integer> conversionTable = new ArrayList<>();

		for (int i = 97; i <= 122; i++) {

			if (skipChar.contains(i)) {
				continue;
			}

			conversionTable.add(i);
		}

		return conversionTable;
	}

	private String convertS(char[] splitS, List<Integer> conversionTable, int index) {

		StringBuilder answer = new StringBuilder();

		for (char eachS : splitS) {

			int conversionTableIndex = makeConversionTableIndex(eachS, conversionTable, index);
			String convertedS = Character.toString(conversionTable.get(conversionTableIndex));

			answer.append(convertedS);
		}

		return answer.toString();
	}

	private int makeConversionTableIndex(char eachS, List<Integer> conversionTable, int index) {

		int conversionTableIndex = conversionTable.indexOf((int)eachS) + index;

		while (conversionTableIndex >= conversionTable.size()) {
			conversionTableIndex -= conversionTable.size();
		}

		return conversionTableIndex;

	}
}
