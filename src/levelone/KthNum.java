package levelone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KthNum {
	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];

		for (int i = 0; i < commands.length; i++) {

			int[] eachCommand = commands[i];

			answer[i] = find(array, eachCommand);
		}

		return answer;

	}

	private int find(int[] array, int[] eachCommand) {

		int indexI = eachCommand[0] - 1;
		int indexJ = eachCommand[1];
		int indexK = eachCommand[2] - 1;

		List<Integer> list = new ArrayList<>();

		for (int i = indexI; i < indexJ; i++) {
			list.add(array[i]);
		}

		Collections.sort(list);

		return list.get(indexK);
	}

}
