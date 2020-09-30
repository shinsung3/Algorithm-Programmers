import java.util.Arrays;

public class Main_NQueen {
	public static void main(String[] args) throws Exception {
		int n = 4;
		int a = solution(n);
		System.out.println(a);
	}

	static int solution(int n) {
		for (int i = 1; i <= n; i++) {
			int[] col = new int[n + 1];
			// 1행 i열에 퀸 놓기.
			col[1] = i;
			// 1행 i열에 퀸을 놓으면 그 다음 어디에 놓을 수 있을지 확인하기.
			dfs(col, 1, n);
		}
		return answer;
	}

	static int answer;

	static void dfs(int[] col, int row, int n) {
		// row행까지는 입력
		// row+1행 입력이 가능한지 확인
		// row = N까지 입력이 되었다면 하나 추가되었다고 볼 수 있음.
		if (row == n) {
			answer++;
			return;
		}

		for (int i = 1; i <= n; i++) {
			int r = row + 1;
			col[r] = i;
//			System.out.println(Arrays.toString(col));
			boolean flag = false;
			// 1행부터 row 행까지 같은 열 혹은 대각선에 위치하는 퀸이 있는지 확인한다.
			for (int j = 1; j < r; j++) {
				// i 행과 row 행의 열 값이 같으면 퀸을 놓을수 없다.
				if (col[j] == col[r])
					flag = true;
				// i 행과 row 행의 열값이 대각선에 위치하는 절대값이면 안된다.
				if (Math.abs(j - r) == Math.abs(col[j] - col[r]))
					flag = true;
				if (flag)
					break;
			}
			if (!flag)
				dfs(col, row + 1, n);
		}
	}
}