import java.util.PriorityQueue;

class Solution {
	public int solution(int[] scoville, int K) {
		int answer = 0;
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();

		for (int i = 0; i < scoville.length; i++) {
			q.add(scoville[i]);
		}

		while (q.peek() <= K) {
			if (q.size() <= 1) {
				answer = -1;
				break;
			}
			int first = q.poll();
			int second = q.poll();

			int value = first + second * 2;
			answer++;

			q.add(value);

		}
		return answer;

	}
}