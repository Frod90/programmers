import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WorkoutClothes {

	public int solution(int n, int[] lost, int[] reserve) {

		Arrays.sort(lost);
		Arrays.sort(reserve);


		List<Integer> extraClothes = Arrays.stream(reserve).boxed().collect(Collectors.toList());
		List<Integer> lostClothes = Arrays.stream(lost).boxed().collect(Collectors.toList());

		for (int eachLost : lostClothes) {

			if (extraClothes.remove((Integer)eachLost)) {
				lostClothes.remove((Integer)eachLost);
			}
		}

		for (int eachReserve : reserve) {

			for (int eachLost : lost) {

				if (!extraClothes.contains(eachReserve) && !lostClothes.contains(eachLost)) {
					continue;
				}

				int sign = Math.abs(eachLost - eachReserve);

				if (sign <= 1) {
					extraClothes.remove((Integer)eachReserve);
					lostClothes.remove((Integer)eachLost);
					break;
				}
			}
		}

		return n - lostClothes.size();

	}

	//이걸로 제출함
	public int solution2(int n, int[] lost, int[] reserve) {

		Arrays.sort(lost);
		Arrays.sort(reserve);

		List<Integer> extraClothes = Arrays.stream(reserve).boxed().collect(Collectors.toList());
		List<Integer> lostClothes = Arrays.stream(lost).boxed().collect(Collectors.toList());

		for (int eachLost : lost) {

			if (extraClothes.contains(eachLost)) {
				extraClothes.remove((Integer)eachLost);
				lostClothes.remove((Integer)eachLost);
			}
		}


		for (int eachLost : lost) {

			for (int eachReserve : reserve) {

				if (!extraClothes.contains(eachReserve)) {
					continue;
				}

				int sign = Math.abs(eachLost - eachReserve);

				if (sign <= 1) {
					extraClothes.remove((Integer)eachReserve);
					lostClothes.remove((Integer)eachLost);
					break;
				}
			}
		}

		return n - lostClothes.size();

	}

	public int solution3(int n, int[] lost, int[] reserve) {

		Arrays.sort(lost);
		Arrays.sort(reserve);

		List<Integer> extraClothes = Arrays.stream(reserve).boxed().collect(Collectors.toList());
		List<Integer> lostClothes = Arrays.stream(lost).boxed().collect(Collectors.toList());

		for (int eachLost : lostClothes) {

			if (extraClothes.remove((Integer)eachLost)) {
				lostClothes.remove((Integer)eachLost);
			}
		}

		for (int eachExtra : extraClothes) {

			for (int eachLost : lostClothes) {
				int sign = Math.abs(eachLost - eachExtra);

				if (sign <= 1) {
					extraClothes.remove((Integer)eachExtra);
					lostClothes.remove((Integer)eachLost);
					break;
				}

			}

		}

		return n - lostClothes.size();
	}

}
