package leveltwo;

import java.util.PriorityQueue;

public class P12978_WithPointObject {

	public int solution(int N, int[][] road, int K) {

		int[][] graph = new int[N + 1][N + 1];

		for (int i = 0; i < road.length; i++) {

			int a = road[i][0];
			int b = road[i][1];
			int v = road[i][2];

			if (graph[a][b] != 0) {
				v = Math.min(v, graph[a][b]);
			}

			graph[a][b] = v;
			graph[b][a] = v;
		}

		int[] dists = calc(N, graph);

		int answer = 0;
		for (int j = 1; j <= N; j++) {
			if (dists[j] <= K) {
				answer++;
			}
		}

		return answer;
	}

	private int[] calc(int N, int[][] graph) {

		int[] dists = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			dists[i] = 10_000 * N;
		}

		PriorityQueue<Point> q = new PriorityQueue<>();
		q.offer(new Point(0, 1));
		dists[1] = 0;

		while (!q.isEmpty()) {

			Point bp = q.poll();

			int bi = bp.getNi();
			int bv = bp.getValue();

			if (dists[bi] < bv) {
				continue;
			}

			for (int i = 0; i <= N; i++) {

				if (graph[bi][i] == 0) {
					continue;
				}
				if (dists[i] < bv + graph[bi][i]) {
					continue;
				}

				q.offer(new Point(bv + graph[bi][i], i));
				dists[i] = bv + graph[bi][i];
			}
		}

		return dists;

	}

	class Point implements Comparable<Point> {

		private final int value;
		private final int ni;

		public Point(int value, int ni) {
			this.value = value;
			this.ni = ni;
		}

		@Override
		public int compareTo(Point point) {
			return this.value - point.value;
		}

		public int getValue() {
			return this.value;
		}

		public int getNi() {
			return this.ni;
		}

	}
}
