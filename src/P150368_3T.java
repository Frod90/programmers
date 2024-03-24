import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P150368_3T {

	List<List<Integer>> result = new ArrayList<>();

	public int[] solution(int[][] users, int[] emoticons) {

		Stack<Integer> discounts = new Stack<>();

		calculate(discounts, 10, emoticons.length, result);

		for (List<Integer> integers : result) {
			System.out.println(integers);
		}

		return new int[] {10, 10000};

	}

	private boolean calculate(Stack<Integer> discounts, int discount, int emoticonsLength, List<List<Integer>> result) {

		if (discounts.size() == emoticonsLength) {

			System.out.println("full: " + discounts);

			List<Integer> each = new ArrayList<>(discounts);
			result.add(each);

			if (discounts.peek().equals(40)) {

				while (discounts.peek().equals(40)) {
					discounts.pop();

					if (discounts.isEmpty()) {
						return false;
					}
				}

			}

			discount = discounts.pop() + 10;
			System.out.println("pop: " + discounts);

			return calculate(discounts, discount, emoticonsLength, result);

		}

		discounts.push(discount);

		return calculate(discounts, discount, emoticonsLength, result);

	}

}

// 이모티콘 별 최소 할인율
