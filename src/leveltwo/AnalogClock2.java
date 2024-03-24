package leveltwo;

public class AnalogClock2 {

	public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {

		int answer = 0;

		if (m1 == 0 && s1 == 0) {
			if (h1 == 0 || h1 == 12) {
				answer++;
			}
		}

		if (h1 < 12 && 12 <= h2) {
			answer--;
		}

		double hSp = 360 / (double)(3600 * 12);
		double mSp = 360 / (double)3600;
		double sSp = 360 / (double)60;

		double hsGapSeconds = 360 / (sSp - hSp);
		double msGapSeconds = 360 / (sSp - mSp);

		int time1 = h1 * 3600 + m1 * 60 + s1;
		int time2 = h2 * 3600 + m2 * 60 + s2;

		int hMeet1 = (int)(time1 / hsGapSeconds);
		int hMeet2 = (int)(time2 / hsGapSeconds);

		int mMeet1 = (int)(time1 / msGapSeconds);
		int mMeet2 = (int)(time2 / msGapSeconds);

		answer += hMeet2 + mMeet2 - hMeet1 - mMeet1;

		return answer;
	}
}
