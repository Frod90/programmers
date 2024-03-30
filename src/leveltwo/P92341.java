package leveltwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P92341 {

	public int[] solution(int[] fees, String[] records) {

		Map<String, List<Integer>> inOutTimes = new HashMap<>();

		for (String record : records) {

			String[] eachRecord = record.split(" ");

			List<Integer> inOutTime = inOutTimes.getOrDefault(eachRecord[1], new ArrayList<>());
			inOutTime.add(toMinute(eachRecord[0]));
			inOutTimes.put(eachRecord[1], inOutTime);
		}

		List<Integer> answer = new ArrayList<>();

		List<String> cars = new ArrayList<>(inOutTimes.keySet());
		cars.sort(Comparator.naturalOrder());

		for (String s : cars) {

			List<Integer> inOutTime = inOutTimes.get(s);

			if (inOutTime.size() % 2 != 0) {
				inOutTime.add(toMinute("23:59"));
			}

			int parkedTime = 0;
			for (int i = 0; i < inOutTime.size(); i += 2) {
				parkedTime = parkedTime + inOutTime.get(i + 1) - inOutTime.get(i);
			}

			if (parkedTime <= fees[0]) {
				answer.add(fees[1]);
				continue;
			}

			int fee = fees[1] + (int)Math.ceil((parkedTime - fees[0]) / (double)fees[2]) * fees[3];
			answer.add(fee);

		}

		return answer.stream().mapToInt(i -> i).toArray();
	}

	private int toMinute(String time) {

		int[] splitedTime = Arrays.stream(time.trim().split(":"))
			.map(Integer::parseInt)
			.mapToInt(i -> i)
			.toArray();

		return splitedTime[0] * 60 + splitedTime[1];
	}

}
