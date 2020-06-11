import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main_이중우선순위큐 {

	public static void main(String[] args) {
		String n[] = { "I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333" };
		int[] a = solution(n);
		System.out.println(Arrays.toString(a));
	}

	static int[] solution(String[] operations) {
		int[] answer = new int[2];
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		PriorityQueue<Integer> before = new PriorityQueue<Integer>(Collections.reverseOrder());
		for (int i = 0; i < operations.length; i++) {
			String[] temp = operations[i].split(" ");
			if (temp[0].equals("I")) {
				int value = Integer.parseInt(temp[1]);
				q.add(value);
				before.add(value);
			} else {
				if (temp[1].equals("-1")) {
					if (q.isEmpty())
						continue;
					while (true) {
						if (q.isEmpty())
							break;
						int a = q.poll();
						if (before.contains(a)) {
							break;
						}
					}
				} else {
					if (before.isEmpty())
						continue;
					while (true) {
						if (before.isEmpty())
							break;
						int a = before.poll();
						if (q.contains(a)) {
							break;
						}
					}
				}
			}
		}
		while (true) {
			if (!q.isEmpty()) {
				int a = q.poll();
				if (before.contains(a)) {
					answer[1] = a;
					break;
				}
			} else {
				break;
			}
		}
		while (true) {
			if (!before.isEmpty()) {
				int a = before.poll();
				if (q.contains(a)) {
					answer[0] = a;
					break;
				}
			} else {
				break;
			}
		}
		return answer;
	}
}