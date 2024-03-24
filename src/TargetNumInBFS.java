import java.util.LinkedList;
import java.util.Queue;

public class TargetNumInBFS {
	public int solution(int[] numbers, int target) {

		int answer = 0;

		Queue<Integer> queue = new LinkedList<>();
		queue.add(numbers[0]);
		queue.add(-numbers[0]);

		for (int i = 1; i < numbers.length; i++) {

			for (int j = 0; j < Math.pow(2, i); j++) {

				int beforeNum = queue.poll();
				int addNum = numbers[i];

				queue.add(beforeNum + addNum);
				queue.add(beforeNum - addNum);
			}
		}

		for (int eachNum : queue) {

			if (eachNum == target) {
				answer++;
			}
		}

		return answer;
	}
}
