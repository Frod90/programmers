import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class P150368 {

	public int[] solution(int[][] users, int[] emoticons) {

		int[] answer = {};

		List<Integer> discountConditions = new ArrayList<>();
		List<Integer> subscriptionConditions = new ArrayList<>();

		for(int[] eachUserInfo : users) {
			discountConditions.add(eachUserInfo[0]);
			subscriptionConditions.add(eachUserInfo[1]);
		}

		discountConditions = discountConditions.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		subscriptionConditions = subscriptionConditions.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

		int maxDiscountCondition = discountConditions.get(0);
		int maxSubscriptionCondition = subscriptionConditions.get(0);

		double maxYield = 0;

		for(int i = 4; i > 0; i--) {

			if(maxDiscountCondition >= i * 10) {

				maxYield = (100 - i * 10) /(double)100;
				break;
			}
		}

		emoticons =Arrays.stream(emoticons).sorted().toArray();

		int totalPrice = Arrays.stream(emoticons).sum();








		return answer;


	}
}
