package leveltwo;

public class P178870 {

	public int[] solution(int[] sequence, int k) {
		int[] answer = {0, sequence.length};

		int sum = 0;
		int endIndex = 0;

		for(int i = 0, j = 0; i < sequence.length; i++) {

			while(sum < k && j < sequence.length) {

				sum += sequence[j];
				endIndex = j;
				j++;
			}


			if(sum == k && answer[1] - answer[0] > endIndex - i) {
				answer[0] = i;
				answer[1] = endIndex;
			}

			sum -= sequence[i];

		}
		return answer;
	}
}
