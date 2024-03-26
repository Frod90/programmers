package leveltwo;

import java.util.ArrayList;
import java.util.List;

public class P150368_5T {

	List<List<Integer>> results = new ArrayList<>();

	public int[] solution(int[][] users, int[] emoticons) {

		List<Integer> discountResults = new ArrayList<>();

		for (int i = 0; i < emoticons.length; i++) {
			discountResults.add(0);
		}

		int[] discounts = {10, 20, 30, 40};
		int maxSize = emoticons.length;

		makeDiscountResults(discounts, 0, discountResults, maxSize);

        /*for (List<Integer> result : results) {
            System.out.println(result);
        }*/

		int[] answer = {0, 0};

		for (List<Integer> result : results) {

			int count = 0;
			int totalQuantity = 0;

			for (int[] user : users) {

				int eachQuantity = 0;

				for (int i = 0; i < emoticons.length; i++) {

					int discount = result.get(i);

					if (discount >= user[0]) {
						eachQuantity += (int)(emoticons[i] * (100 - discount) / 100.0);
					}
				}

				if (eachQuantity >= user[1]) {
					eachQuantity = 0;
					count++;
				}

				totalQuantity += eachQuantity;
			}

			if (count > answer[0]) {
				answer[0] = count;
				answer[1] = totalQuantity;

			} else if (count == answer[0] && totalQuantity > answer[1]) {
				answer[1] = totalQuantity;
			}

		}

		return answer;
	}

	private void makeDiscountResults(int[] discounts, int depth, List<Integer> discountResults, int maxSize) {

		if (depth == maxSize) {

			results.add(new ArrayList<>(discountResults));
			return;
		}

		for (int i = 0; i < discounts.length; i++) {
			discountResults.set(depth, discounts[i]);
			makeDiscountResults(discounts, depth + 1, discountResults, maxSize);
		}

	}

}
