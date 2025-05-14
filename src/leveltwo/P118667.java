package leveltwo;

import java.util.Arrays;
import java.util.OptionalInt;

public class P118667 {

	public int solution(int[] queue1, int[] queue2) {

		long sum1 = Arrays.stream(queue1).sum();
		long sum2 = Arrays.stream(queue2).sum();
		int qLength = queue1.length;

		if ((sum1 + sum2) % 2 != 0) {
			return -1;
		}

		int totalCount = qLength * 4;
		int index1 = 0;
		int index2 = 0;

		while (totalCount-- > 0) {

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
