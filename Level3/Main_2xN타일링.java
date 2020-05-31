public class Main_2xN타일링 {

	public static void main(String[] args) {
		int n = 4;
		int a = solution(n);
		System.out.println(a);
	}

	public static int solution(int n) {
		int answer = 0;
		int[] dp = new int[n + 1];
		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i < dp.length; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
		}

		answer = dp[n];
		return answer;
	}
}