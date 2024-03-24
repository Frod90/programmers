package levelone;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class HallOfFameTV {
	public int[] solution(int k, int[] score) {

		List<Integer> rank = new ArrayList<>();
		List<Integer> answer = new ArrayList<>();

		for (int i = 0; i < score.length; i++) {

			rank.add(score[i]);
			rank.sort(Comparator.reverseOrder());

			if (rank.size() > k) {
				rank.remove(rank.size() - 1);
			}

			answer.add(rank.get(rank.size() - 1));

		}

		return answer.stream().mapToInt(i -> i).toArray();
	}

	public int[] solution2(int k, int[] score) {

		List<Integer> answer = new ArrayList<>();

		PriorityQueue<Integer> priorityQueueLowest = new PriorityQueue<>();

		for (int eachScore : score) {

			priorityQueueLowest.add(eachScore);

			if (priorityQueueLowest.size() > k) {
				priorityQueueLowest.poll();
			}

			answer.add(priorityQueueLowest.peek());

		}

		return answer.stream().mapToInt(i -> i).toArray();
	}

}
