package leveltwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class P12972_WithoutObject {

	public int solution(int N, int[][] road, int K) {
		List<List<int[]>> graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int[] r : road) {
			int a = r[0], b = r[1], cost = r[2];
			graph.get(a).add(new int[] {b, cost});
			graph.get(b).add(new int[] {a, cost});
		}

		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[1] = 0;

		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
		pq.offer(new int[] {0, 1});

		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int cost = cur[0], now = cur[1];

			if (dist[now] < cost)
				continue;

			for (int[] next : graph.get(now)) {
				int nextNode = next[0];
				int nextCost = cost + next[1];

				if (dist[nextNode] > nextCost) {
					dist[nextNode] = nextCost;
					pq.offer(new int[] {nextCost, nextNode});
				}
			}
		}

		int answer = 0;
		for (int i = 1; i <= N; i++) {
			if (dist[i] <= K)
				answer++;
		}

		return answer;
	}

}
