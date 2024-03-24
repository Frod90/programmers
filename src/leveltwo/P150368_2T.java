package leveltwo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class P150368_2T {

	public int[] solution(int[][] users, int[] emoticons) {

		int[][] emoticonsPrices = new int[emoticons.length][];

		for (int i = 0; i < emoticons.length; i++) {

			int price = emoticons[i];
			emoticonsPrices[i] =
				new int[] {(int)(price * 0.9), (int)(price * 0.8), (int)(price * 0.7), (int)(price * 0.6)};
		}

		int count = 0;

		List<int[]> subscriptionUsers = new ArrayList<>();

		for (int i = 0; i < users.length; i++) {
			if (isSubscription(users[i], emoticonsPrices)) {
				count++;
				subscriptionUsers.add(users[i]);
			}
		}




		return new int[] {count, 10000};

	}

	// private int[] calculateDiscountCondition(int[] subscriptionUser, int[][] emoticonPrices) {
	//
	// 	int purchaseCondition =  (int)Math.ceil((double)subscriptionUser[0] / 10) * 10;
	//
	//
	//
	//
	// }

	private boolean isSubscription(int[] user, int[][] emoticonsPrices) {

		int purchaseCondition = (int)Math.ceil((double)user[0] / 10);

		int sum = 0;

		for (int i = 0; i < emoticonsPrices.length; i++) {
			sum += emoticonsPrices[i][purchaseCondition - 1];
		}

		return user[1] <= sum;

	}
}

// 이모티콘 별 최소 할인율
