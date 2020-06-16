import java.util.PriorityQueue;

public class Main_예산 {

	public static void main(String[] args) {
		int[] b = { 120, 110, 140, 150 };
		int m = 485;
		int a = solution(b, m);
		System.out.println(a);
	}

	static int solution(int[] budgets, int M) {
		int answer = 0;

		// 1. 가장 먼저 모두 더해서 평균 값을 구함.
		long sum = 0;
		for (int i = 0; i < budgets.length; i++) {
			sum += budgets[i];
		}
		if (sum > M) {
			// 3. 더 크면 가장 먼저 M의 평균을 구함.
			int avg = M / budgets.length;
			PriorityQueue<Integer> q = new PriorityQueue<Integer>();
			for (int i = 0; i < budgets.length; i++) {
				q.add(budgets[i]);
			}

			// 4. 더 큰 값을 찾아냄.
			sum = 0;
			while (!q.isEmpty()) {
				if (q.peek() < avg) {
					sum += q.poll();
				} else {
					avg++;
					int len = q.size();
					int temp = avg * len;
					sum += temp;
					if (sum > M) {
						answer = avg - 1;
						break;
					} else if (sum == M) {
						answer = avg;
						break;
					} else {
						sum -= temp;
					}
				}
			}

		} else {
			// 2. 작거나 같을 경우 상한액을 보냄. 가장 큰 값을 보내면 됨.
			for (int i = 0; i < budgets.length; i++) {
				answer = Math.max(answer, budgets[i]);
			}
		}
		return answer;
	}
}