import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main_야근지수 {

	public static void main(String[] args) {
		int n = 4;
		int[] works = { 4, 3, 3 };
		long a = solution(n, works);
		System.out.println(a);
	}

	static long solution(int n, int[] works) {
		long answer = 0;

		Arrays.sort(works);
		if (works.length == 1) {
			answer = works[0] - n;
			if (answer < 0)
				answer = 0;
			else
				answer *= answer;
		} else {
			PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());

			for (int work : works) {
				p.offer(work);
			}

			for (int i = 0; i < n; i++) {
				int max = (int) p.poll();
				System.out.println(max);
				if (max <= 0)
					break;
				p.offer(max - 1);
				System.out.println(p);
			}

			while (!p.isEmpty()) {
				int value = p.poll();
				answer += value * value;
			}
		}
		return answer;
	}
}