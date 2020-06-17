import java.util.Arrays;

public class Main_등굣길 {

	public static void main(String[] args) {
		int m = 4;
		int n = 3;
		int[][] p = { { 2, 2 } };
		int a = solution(m, n, p);
		System.out.println(a);
	}

	static int solution(int m, int n, int[][] puddles) {
		int answer = 0;
		int[][] map = new int[n][m];
		boolean visit[][] = new boolean[n][m];
		for (int i = 0; i < puddles.length; i++) {
			visit[puddles[i][1] - 1][puddles[i][0] - 1] = true;
		}
		for (int i = 0; i < m; i++) {
			if (!visit[0][i]) {
				map[0][i] = 1;
			} else {
				break;
			}
		}
		for (int i = 0; i < n; i++) {
			if (!visit[i][0]) {
				map[i][0] = 1;
			} else {
				break;
			}
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (!visit[i][j])
					map[i][j] = (map[i - 1][j] + map[i][j - 1]) % 1000000007;
			}
		}
		// for (int[] a : map)
		// System.out.println(Arrays.toString(a));
		answer = map[n - 1][m - 1];
		return answer;
	}
}