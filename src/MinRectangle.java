public class MinRectangle {

	public int solution(int[][] sizes) {

		int maxW = 0;
		int maxH = 0;

		for(int[] eachSize : sizes) {

			int w = Math.max(eachSize[0], eachSize[1]);
			int h = Math.min(eachSize[0], eachSize[1]);

			maxW = Math.max(maxW, w);
			maxH = Math.max(maxH, h);

		}

		return maxH * maxW;
	}
}
