public class Main_N으로표현 {

	public static void main(String[] args) {
		int N = 5;
		int number = 12;
		int a = solution(N, number);
		System.out.println(a);
	}

	static int solution(int N, int number) {
		dfs(N, number, 0, 0);
		if (answer > 8)
			return -1;
		return answer;
	}

	static int answer = Integer.MAX_VALUE;

	static void dfs(int n, int number, int idx, int sum) {
		if (idx > 8)
			return;
		if (sum == number) {
			answer = Math.min(idx, answer);
		}
		int temp = 0;
		for (int i = 1; i <= 8; i++) {
			temp = temp * 10 + n;
			dfs(n, number, idx + i, sum + temp);
			dfs(n, number, idx + i, sum - temp);
			dfs(n, number, idx + i, sum / temp);
			dfs(n, number, idx + i, sum * temp);
		}
	}
}