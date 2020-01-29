import java.util.Arrays;

public class Main_체육복 {

	public static void main(String[] args) {
		int n = 10;
		int lost[] = { 3, 9, 10 };
		int reverse[] = { 3, 8, 9 };
		int c = solution(n, lost, reverse);
		System.out.println(c);
	}

	static int solution(int n, int[] lost, int[] reserve) {
		int answer = n - lost.length;

		for (int i = 0; i < lost.length; i++) {
			int c = lost[i];

			for (int j = 0; j < reserve.length; j++) {
				if (c == reserve[j]) {
					reserve[j] = -1;
					lost[i] = -1;
					answer++;
					break;
				}
			}
		}
		for (int i = 0; i < lost.length; i++) {
			int a = lost[i] - 1;
			int b = lost[i] + 1;

			for (int j = 0; j < reserve.length; j++) {
				if (a == reserve[j] || b == reserve[j]) {
					reserve[j] = -1;
					answer++;
					break;
				}
			}
		}

		System.out.println(Arrays.toString(reserve));

		return answer;
	}
}