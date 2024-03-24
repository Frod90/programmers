package levelone;

public class KnightWeapon {

	public int solution(int number, int limit, int power) {
		int answer = 0;

		for (int i = 1; i <= number; i++) {
			answer += calculateDivisor(i, limit, power);
		}

		return answer;
	}

	private int calculateDivisor(int eachNumber, int limit, int power) {

		int divisor = 0;
		double numberOfSquares = Math.sqrt(eachNumber);

		for (int i = 1; i <= numberOfSquares; i++) {

			if (i == numberOfSquares) {
				divisor++;
				continue;
			}

			if (eachNumber % i == 0) {
				divisor += 2;
			}
		}

		if (divisor > limit) {
			return power;
		}

		return divisor;
	}

}
