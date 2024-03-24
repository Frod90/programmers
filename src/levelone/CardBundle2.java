package levelone;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CardBundle2 {

	public String solution(String[] cards1, String[] cards2, String[] goal) {

		List<String> cardList1 = Arrays.stream(cards1).collect(Collectors.toList());
		List<String> cardList2 = Arrays.stream(cards2).collect(Collectors.toList());

		for(String eachGoal : goal) {

			boolean removeSign = false;

			if(!cardList1.isEmpty() && cardList1.get(0).equals(eachGoal)) {
				cardList1.remove(eachGoal);
				removeSign = true;
			}

			if(!cardList2.isEmpty() && cardList2.get(0).equals(eachGoal)) {
				cardList2.remove(eachGoal);
				removeSign = true;
			}

			if(!removeSign) {
				return "No";
			}

		}

		return "Yes";

	}
}
