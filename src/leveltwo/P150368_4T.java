package leveltwo;

import static java.util.Arrays.*;

import java.util.ArrayList;
import java.util.List;

public class P150368_4T {

	public int[] solution(int[][] users, int[] emoticons) {

		List<Integer> discounts = new ArrayList<>();

		for (int i = 0; i < emoticons.length; i++) {
			discounts.add(0);
		}
		int[] defaultDiscounts = {10, 20, 30, 40};

		calculate(discounts, 0, defaultDiscounts, emoticons.length);

		return new int[] {10, 10000};

	}

	List<int[]> result = new ArrayList<>();

	private void calculate(List<Integer> discounts, int depth, int[] defaultDiscounts, int emoticonsLength) {

		if (depth == emoticonsLength) {
			int[] eachResult = new int[discounts.size()];

			for (int i = 0; i < discounts.size(); i++) {
				eachResult[i] = discounts.get(i);
			}
			result.add(eachResult);

			System.out.println(discounts);
			return;
		}


		for (int i = 0; i < 4; i++) {

			discounts.set(depth,defaultDiscounts[i]);
			calculate(discounts, depth + 1, defaultDiscounts, emoticonsLength);
		}
	}

}

// 이모티콘 별 최소 할인율
