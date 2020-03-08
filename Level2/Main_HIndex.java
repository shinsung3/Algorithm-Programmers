import java.util.Arrays;

public class Main_HIndex {
	public static int solution(int[] citations) {
		int answer = 0;

		Arrays.sort(citations);
		boolean isZero = true;
		for (int i = 0; i < citations.length; i++) {
			if (citations[i] != 0) {
				isZero = false;
				break;
			}
		}

		if (!isZero) {
			for (int i = 1; i <= 10000; i++) {
				int cnt = 0;
				for (int j = 0; j < citations.length; j++) {
					if (citations[j] >= i) {
						cnt++;
					}
				}
				if(i<=cnt) {
					answer = Math.max(i, answer);
				}
			}
		} else {
			answer = 0;
		}
		return answer;
	}

	public static void main(String[] args) {
		int[] c = { 4,3,3,3,3 };

		int str = solution(c);
		System.out.println(str);
	}
}