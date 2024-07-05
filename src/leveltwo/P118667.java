package leveltwo;

public class P118667 {
	public static void main(String[] args) {
		P118667 p118667 = new P118667();

		int solution = p118667.solution(new int[] {1, 1, 1, 1, 1, 1}, new int[] {1, 1, 1, 1, 11, 1});
		System.out.println(solution);

	}

	public int solution(int[] queue1, int[] queue2) {

		long sum1 = 0;
		long sum2 = 0;
		int qLength = queue1.length;

		for (int i = 0; i < qLength; i++) {
			sum1 += queue1[i];
			sum2 += queue2[i];
		}

		// System.out.println("sum = " + (sum1 + sum2));;

		if ((sum1 + sum2) % 2 != 0) {
			return -1;
		} else if ((sum1 + sum2) == 0) {
			return 0;
		}

		int totalCount = qLength * 4;
		int index1 = 0;
		int index2 = 0;

		while (totalCount-- > 0) {

			System.out.println("count = " + (index1 + index2) + ", sum1 = " + sum1 + ", sum2 = " + sum2);

			if (sum1 == sum2) {
				return index1 + index2;

			} else if (sum1 > sum2) {

				int poll;

				if (index1 < qLength) {
					poll = queue1[index1++];
				} else {
					poll = queue2[index1++ % qLength];
				}

				sum1 -= poll;
				sum2 += poll;

			} else if (sum1 < sum2) {

				int poll;

				if (index2 < qLength) {
					poll = queue2[index2++];
				} else {
					poll = queue1[index2++ % qLength];
				}

				sum2 -= poll;
				sum1 += poll;
			}
		}

		return -1;
	}

}
