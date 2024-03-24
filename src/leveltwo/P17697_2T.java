package leveltwo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class P17697_2T {

	public static void main(String[] args) {

		int m = 4;
		int n = 5;
		String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};

		P17697_2T p17697 = new P17697_2T();
		System.out.println(p17697.solution(4, 5, board));

		String[] board02 = {""};
		System.out.println(p17697.solution(board02.length, board02[0].length(), board02));

	}

	char[][] splitBoard;

	public int solution(int m, int n, String[] board) {
		int answer = 0;

		Set<Character> characters = new HashSet<>();
		for (String eachBoard : board) {
			char[] split = eachBoard.toCharArray();

			for (char c : split) {
				characters.add(c);
			}
		}

		splitBoard = new char[board.length][board[0].length()];

		for (int i = 0; i < splitBoard.length; i++) {
			splitBoard[i] = board[i].toCharArray();
		}

		do {

			for (Character c : characters) {
				List<int[]> indexs = match(c);
				if (indexs.isEmpty()) {
					continue;
				}

				for (int[] index : indexs) {
					splitBoard[index[0]][index[1]] = ' ';
				}
			}
		} while (cleanUp());

		for (char[] eachBoard : splitBoard) {
			for (char each : eachBoard) {
				if (each == ' ') {
					answer++;
				}
			}
		}

		return answer;
	}

	private List<int[]> match(char icon) {

		List<int[]> indexs = new ArrayList<>();

		for (int i = 0; i < splitBoard.length; i++) {

			for (int j = 0; j < splitBoard[i].length; j++) {

				if ((i == splitBoard.length - 1) || (j == splitBoard[i].length - 1)) {
					continue;
				}

				if (splitBoard[i][j] == icon &&
					splitBoard[i + 1][j] == icon &&
					splitBoard[i][j + 1] == icon &&
					splitBoard[i + 1][j + 1] == icon
				) {
					indexs.add(new int[] {i, j});
					indexs.add(new int[] {i + 1, j});
					indexs.add(new int[] {i, j + 1});
					indexs.add(new int[] {i + 1, j + 1});
				}
			}
		}

		return indexs;
	}

	private boolean cleanUp() {

		boolean clearSign = false;

		for (int i = 0; i < splitBoard[0].length; i++) {
			Queue<Character> queue = new LinkedList<>();

			for (int j = 0; j < splitBoard.length - 1; j++) {
				queue.add(splitBoard[j][i]);
			}

			int j = splitBoard.length - 1;
			while (!queue.isEmpty()) {
				char ch = queue.poll();
				if (ch == ' ') {
					continue;
				}

				clearSign = true;
				splitBoard[j][i] = ch;
				j--;
			}

			for (int k = j; k >= 0; k--) {
				splitBoard[j][i] = ' ';
			}
		}

		return clearSign;
	}
}

