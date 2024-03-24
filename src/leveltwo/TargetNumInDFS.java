package leveltwo;

public class TargetNumInDFS {

	public static void main(String[] args) {

		int[] numbers = {4, 1, 2, 1};
		int target = 4;

		TargetNumInDFS targetNumInDFS = new TargetNumInDFS();
		targetNumInDFS.solution(numbers, target);

	}

	int answer = 0;

	public int solution(int[] numbers, int target) {

		int count = 0;
		int sum = 0;

		countTarget(numbers, count, sum, target);
		return answer;
	}

	private void countTarget(int[] numbers, int count, int sum, int target) {

		if (count < numbers.length) {

			int sum1 = sum + numbers[count];
			countTarget(numbers, count + 1, sum1, target);

			int sum2 = sum - numbers[count];
			countTarget(numbers, count + 1, sum2, target);

		} else {

			System.out.println(sum);

			if (sum == target) {
				answer++;
			}
		}
	}

}
