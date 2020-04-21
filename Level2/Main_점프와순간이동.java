public class Main_점프와순간이동 {
	public static void main(String[] args) {
		int n = 5;
		int a = solution(n);
		System.out.println(a);
	}

	static int solution(int n) {
		int ans = 0;

		while (n > 0) {
			if (n % 2 == 0) {
				n /= 2;
			} else {
				n--;
				ans++;
			}
		}
		return ans;
	}
}