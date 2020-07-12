import java.util.Arrays;

public class Main_숫자게임 {

	public static void main(String[] args) {
//		int a[] = { 5, 1, 3, 7 };
//		int b[] = { 2, 2, 6, 8 };
//		int a[] = { 2, 2, 2, 2 };
//		int b[] = { 1, 1, 1, 1 };
		int a[] = { 2, 3, 4, 5, 6, 7 };
		int b[] = { 2, 3, 4, 5, 6, 7 };

		int ans = solution(a, b);
		System.out.println(ans);
	}

	static int solution(int[] A, int[] B) {
		int answer = 0;
		Arrays.sort(A);
		Arrays.sort(B);

		int idx = 0;
		for (int i = 0; i < B.length; i++) {
			if (A[idx] < B[i]) {
				answer++;
				idx++;
			}
		}
		return answer;
	}
}