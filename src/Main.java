import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {

		P150368_4T p1503682T = new P150368_4T();

		int[][] users = {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}};
		int[] emo = {1300, 1500, 1600, 4900};

		p1503682T.solution(users, emo);
	}


}