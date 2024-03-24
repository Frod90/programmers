package levelone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CardBundle {

	public String solution(String[] cards1, String[] cards2, String[] goal) {

		List<String> sentence = Arrays.stream(goal).collect(Collectors.toList());

		List<Integer> filteredCardsIndex1 = toList(cards1, sentence);
		int filteredCardsSize1 = filteredCardsIndex1.size();
		if(filteredCardsIndex1.contains(-1)) {
			filteredCardsSize1 -= 1;
		}
		boolean result1 = checkPossibility(filteredCardsIndex1);

		List<Integer> filteredCardsIndex2 = toList(cards2, sentence);
		int filteredCardsSize2 = filteredCardsIndex2.size();
		if(filteredCardsIndex2.contains(-1)) {
			filteredCardsSize2 -= 1;
		}
		boolean result2 = checkPossibility(filteredCardsIndex2);

		if(filteredCardsSize1 + filteredCardsSize2 != goal.length) {
			return "No";
		}


		if (result1 && result2) {
			return "Yes";
		}

		return "No";
	}

	private List<Integer> toList(String[] cards, List<String> sentence) {

		return Arrays.stream(cards)
			.map(sentence::indexOf)
			.distinct()
			.collect(Collectors.toList());
	}

	private List<Integer> toTest(String[] cards, List<String> sentence) {

		List<Integer> filteredCardsIndex = new ArrayList<>();

		for (String card : cards) {

			int index = sentence.indexOf(card);

			if (filteredCardsIndex.contains(index)) {
				continue;
			}

			filteredCardsIndex.add(index);

		}

		return filteredCardsIndex;
	}

	private boolean checkPossibility(List<Integer> filteredCardsIndex) {

		final int CORRECT_FACTOR = 1;

		for (int i = 0; i < filteredCardsIndex.size() - CORRECT_FACTOR; i++) {

			if (filteredCardsIndex.get(i) == -1) {
				return false;
			}

			if (filteredCardsIndex.get(i + 1) == -1) {
				continue;
			}

			if (filteredCardsIndex.get(i) > filteredCardsIndex.get(i + 1)) {
				return false;
			}
		}

		return true;
	}

}
