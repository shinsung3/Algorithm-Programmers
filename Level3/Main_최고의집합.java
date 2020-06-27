import java.util.Arrays;

public class Main_최고의집합 {
	public static void main(String[] args) {
		int n = 5;
		int s = 15;
		int[] arr = solution(n, s);
		System.out.println(Arrays.toString(arr));
	}

	static int[] solution(int n, int s) {
		int[] answer = new int[n];
		if (n > s) {
			return new int[] { -1 };
		} else {
			for (int i = 0; i < n; i++) {
				if (i >= n - (s % n)) {
					answer[i] = s / n + 1;
				} else {
					answer[i] = s / n;
				}
			}
			return answer;
		}
	}
}