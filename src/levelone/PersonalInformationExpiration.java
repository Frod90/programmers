package levelone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PersonalInformationExpiration {

	public int[] solution(String today, String[] terms, String[] privacies) {

		Map<String, Integer> conditions = toMap(terms);

		List<Integer> splitToday = Arrays.stream(today.split("\\."))
			.map(Integer::parseInt)
			.collect(Collectors.toList());

		List<Integer> answer = new ArrayList<>();

		for (int i = 0; i < privacies.length; i++) {

			if (overExpirationDate(splitToday, conditions, privacies[i])) {
				answer.add(i + 1);
			}
		}

		return answer.stream().mapToInt(i -> i).toArray();
	}

	private Map<String, Integer> toMap(String[] terms) {

		Map<String, Integer> conditions = new HashMap<>();

		for (String eachTerm : terms) {
			String[] splitEachTerm = eachTerm.split(" ");

			int storagePeriod = Integer.parseInt(splitEachTerm[1]);

			conditions.put(splitEachTerm[0], storagePeriod);
		}

		return conditions;
	}

	private boolean overExpirationDate(List<Integer> today, Map<String, Integer> conditions, String eachPrivacy) {

		String[] splitEachPrivacy = eachPrivacy.split(" ");

		int storagePeriod = conditions.get(splitEachPrivacy[1]);

		List<Integer> collectionDate = Arrays.stream(splitEachPrivacy[0].split("\\."))
			.map(Integer::parseInt)
			.collect(Collectors.toList());

		int year = collectionDate.get(0);
		int month = collectionDate.get(1) + storagePeriod;
		int date = collectionDate.get(2);

		while (month > 12) {
			month -= 12;
			year++;
		}

		if (year > today.get(0)) {
			return false;
		}

		if (year == today.get(0) && month > today.get(1)) {
			return false;
		}

		if (year == today.get(0) && month == today.get(1) && date > today.get(2)) {
			return false;
		}

		return true;

	}

}
