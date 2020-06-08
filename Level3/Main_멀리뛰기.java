public class Main_멀리뛰기 {

	public static void main(String[] args) {
//		int n = 4;
//		int n = 3;
		int n = 1;
		long a = solution(n);
		System.out.println(a);
	}

	static long solution(int n) {
		long answer = 0;
		if (n == 1) {
			return 1;
		}
		int dp[] = new int[n + 1];
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i < n + 1; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
		}
		answer = dp[n];
		return answer;
	}
}