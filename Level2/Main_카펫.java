import java.util.Arrays;

public class Main_카펫 {
	public static void main(String[] args) {
		int b = 40;
		int r = 8;
		int a[] = solution(b, r);
		System.out.println(Arrays.toString(a));
	}

	static int[] solution(int brown, int red) {
		int[] answer = new int[2];
		int sum = brown + red;

		for (int i = 1; i <= sum; i++) {
			if (sum % i == 0) {

				int h = i;
				int w = sum / i;

				if ((h - 2) * (w - 2) == red) {
					answer[0] = Math.max(h, w);
					answer[1] = Math.min(h, w);
				}
			}
		}
		return answer;
	}
}