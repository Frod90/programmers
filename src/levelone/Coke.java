package levelone;

public class Coke {
	public int solution(int a, int b, int n) {

		int answer = 0;

		do {
			int tradedBottle = n / a;
			answer += tradedBottle * b;
			n = n - tradedBottle * a + tradedBottle * b;
		} while (n >= a);

		return answer;
	}

}
