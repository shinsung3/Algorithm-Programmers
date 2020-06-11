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
		PriorityQueue<Integer> minQueue = new PriorityQueue<Integer>();
		PriorityQueue<Integer> maxQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
		for (int i = 0; i < operations.length; i++) {
			String[] temp = operations[i].split(" ");
			if (temp[0].equals("I")) {
				int value = Integer.parseInt(temp[1]);
				minQueue.add(value);
				maxQueue.add(value);
			} else {
				if (temp[1].equals("-1")) {
					if (minQueue.isEmpty())
						continue;
					while (true) {
						if (minQueue.isEmpty())
							break;
						int a = minQueue.poll();
						if (maxQueue.contains(a)) {
							break;
						}
					}
				} else {
					if (maxQueue.isEmpty())
						continue;
					while (true) {
						if (maxQueue.isEmpty())
							break;
						int a = maxQueue.poll();
						if (minQueue.contains(a)) {
							break;
						}
					}
				}
			}
		}
		while (true) {
			if (!minQueue.isEmpty()) {
				int a = minQueue.poll();
				if (maxQueue.contains(a)) {
					answer[1] = a;
					break;
				}
			} else {
				break;
			}
		}
		while (true) {
			if (!maxQueue.isEmpty()) {
				int a = maxQueue.poll();
				if (minQueue.contains(a)) {
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