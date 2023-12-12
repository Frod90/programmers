public class Main {
	public static void main(String[] args) {

		String[] keymap = {"AGZ", "BSSS"};
		String[] targets = {"ASA","BGZ"};

		Solution solution = new Solution();
		int[] answer = solution.solution(keymap, targets);

		for(int eachAnswer : answer) {
			System.out.println(eachAnswer);
		}


	}
}