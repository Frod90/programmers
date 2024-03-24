import java.util.HashMap;
import java.util.Map;

public class Phonekemon {

	public int solution(int[] nums) {

		Map<Integer, Integer> pokemonCategory = new HashMap<>();

		for (int eachNum : nums) {
			pokemonCategory.put(eachNum, pokemonCategory.getOrDefault(eachNum, 0) + 1);
		}

		int maxPick = nums.length / 2;

		return Math.min(maxPick, pokemonCategory.size());

	}
}
