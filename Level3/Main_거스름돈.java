public class Main_거스름돈 {

	public static void main(String[] args) {
		int n = 5;
		int[] money = { 1, 2, 5 };
		int a = solution(n, money);
		System.out.println(a);
	}

	static int solution(int n, int[] money) {
		int answer = 0;
		int[][] dp = new int[money.length + 1][n + 1];

		dp[0][0] = 1;
		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (j < money[i - 1]) {
					dp[i][j] = dp[i - 1][j] % 1000000007;
				} else if (j == money[i - 1]) {
					dp[i][j] = (dp[i - 1][j] + 1) % 1000000007;
				} else {
					dp[i][j] = (dp[i - 1][j] + dp[i][j - money[i - 1]]) % 1000000007;
				}
			}
		}
		answer = dp[money.length][n];
		return answer;
	}
}