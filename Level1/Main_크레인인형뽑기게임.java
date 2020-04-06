import java.util.Arrays;
import java.util.Stack;

public class Main_크레인인형뽑기게임 {
	public static void main(String[] args) {
		int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
				{ 3, 5, 1, 3, 1 } };
		int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };
		System.out.println(Arrays.toString(moves));
		for (int[] a : board)
			System.out.println(Arrays.toString(a));
		int a = solution(board, moves);
		System.out.println(a);
	}

	static int solution(int[][] board, int[] moves) {
		int answer = 0;
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < moves.length; i++) {
			int tmp = moves[i] - 1;

			for (int j = 0; j < board[tmp].length; j++) {
				if (board[j][tmp] != 0) {
					int key = board[j][tmp];
					board[j][tmp] = 0;
					if (!stack.isEmpty()) {
						if (key == stack.peek()) {
							stack.pop();
							answer+=2;
						} else {
							stack.add(key);
						}
					} else {
						stack.add(key);
					}
					break;
				}
			}
		}
		return answer;
	}
}