package leveltwo;

public class AnalogClock {
	public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
		int answer = 0;

		double hSp = 360 / (double)(360 * 12);
		double mSp = 360 / (double)360;
		double sSp = 360 / (double)60;

		// if(h1 == 12) {
		// 	h1 = 0;
		// }
		//
		// if(h2 == 12) {
		// 	h2 = 0;
		// }

		int time1 = h1 * 3600 + m1 * 60 + s1;
		int time2 = h2 * 3600 + m2 * 60 + s2;
		int givenTime = time2 - time1;

		double sDistance = givenTime * sSp;

		int sRound = (int)(sDistance / 360);
		double sRest = sDistance % 360;

		double hStart = h1 * 30 + hSp * s1;
		//double hEnd = (h1 * 30 + hSp * sDistance) % 360;
		double hEnd = h2 * 30 + hSp * s2;

		double mStart = m1 * 6 + mSp * s1;
		//double mEnd = (m1 * 6 + mSp * sDistance) % 360;
		double mEnd = m1 * 6 + mSp * s2;

		if (s1 * 6 < hStart && hEnd < s1 * 6 + sRest) {
			answer++;
		}

		if (s1 * 6 < mStart && mEnd < s1 * 6 + sRest) {
			answer++;
		}

		System.out.println("Round: " + sRound + "Rest: " + sRest);
		System.out.println("s2: " + s2 * 6 + "sRest" + s1 * 6 + sRest);

		return answer + sRound * 2;
	}
}
