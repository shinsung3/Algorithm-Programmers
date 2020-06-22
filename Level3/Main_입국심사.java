import java.util.Arrays;

public class Main_입국심사 {
	public static void main(String[] args) {
		int n = 6;
		int[] times = { 7, 10 };
		long a = solution(n, times);
		System.out.println(a);
	}

	static long solution(int n, int[] times) {
		long answer = 0;
		Arrays.sort(times);
		// 최적
		long min = 1;
		// 최악
		long max = (long) times[times.length - 1] * n;
		long mid = 0;
		long sum = 0;
		answer = max;
		while (min <= max) {
			sum = 0;
			mid = (min + max) / 2;
			for (int t : times) {
				sum += (long) (mid / t);
			}

			if (sum >= n) {
				if (mid < answer) {
					answer = mid;
				}
				max = mid - 1;
			} else {
				min = mid + 1;
			}
		}
		return answer;
	}
}