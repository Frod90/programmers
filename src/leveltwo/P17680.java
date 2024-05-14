package leveltwo;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class P17680 {

	public int solution(int cacheSize, String[] cities) {
		int answer = 0;

		Queue<String> inputs = new LinkedList<>();
		Set<String> caches = new HashSet<>();

		for (String city : cities) {

			if (cacheSize <= 0) {
				answer += 5;
				continue;
			}

			city = city.toUpperCase();

			if (caches.contains(city)) {
				inputs.remove(city);
				answer++;

			} else {

				if (caches.size() >= cacheSize) {
					String beforeCity = inputs.poll();
					caches.remove(beforeCity);
				}

				answer += 5;
			}

			caches.add(city);
			inputs.add(city);

			// System.out.println(caches + " ||| " + inputs);

		}

		return answer;
	}
}
