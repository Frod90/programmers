package leveltwo;

import java.util.HashSet;
import java.util.Set;

public class P131701 {

	public int solution(int[] elements) {

		Set<Integer> answer = new HashSet<>();

		for(int i = 1; i <= elements.length; i++) {

			for(int k = 0; k < elements.length; k++) {

				int sum = 0;

				for(int j = 0, index = k; j < i; j++) {

					if(index >= elements.length) {
						index = 0;
					}
					sum += elements[index];
					index++;
				}
				answer.add(sum);
			}



		}
		return answer.size();
	}
}
