import java.util.Arrays;

public class Main_가장큰정사각형찾기 {
	public static void main(String[] args) {
		int b[][] = { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 0, 1, 0 } };
//		int b[][] = {{0,1,1,1},{1,1,1,1}};
//		int b[][] = {{0,1},{0,0}};
		int a = solution(b);

		for (int[] c : b)
			System.out.println(Arrays.toString(c));
		System.out.println();
		System.out.println(a);
	}

	static int solution(int[][] board) {
		int answer = 0;
		for (int i = 1; i < board.length; i++) {
			for (int j = 1; j < board[0].length; j++) {
				int a = board[i - 1][j];
				int b = board[i - 1][j - 1];
				int c = board[i][j - 1];
				int d = board[i][j];

				if (a >= 1 && b >= 1 && c >= 1 && d >= 1) {
					board[i][j] = Math.min(a, Math.min(c, b)) + 1;
				}
			}
		}

		int max = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				max = Math.max(max, board[i][j]);
			}
		}

		answer = max * max;

		return answer;
	}
}