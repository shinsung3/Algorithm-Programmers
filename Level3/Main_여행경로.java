import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main_여행경로 {

	public static void main(String[] args) {
		String[][] s = { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" }, { "ATL", "SFO" } };

		String[] a = solution(s);
		System.out.println(Arrays.toString(a));
	}

	static String[] solution(String[][] tickets) {
		String[] answer = {};
		Queue<Place> q = new LinkedList<>();
		boolean visit[] = new boolean[tickets.length + 1];
		visit[0] = true;
		q.add(new Place("ICN", visit, "ICN"));

		List<String> list = new ArrayList<String>();

		while (!q.isEmpty()) {
			Place p = q.poll();
//			System.out.println(p);

			boolean flag = false;
			for (int i = 0; i < p.value.length; i++) {
				if (!p.value[i]) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				list.add(p.now);
			} else {

				for (int i = 0; i < tickets.length; i++) {
					if (p.name.equals(tickets[i][0])) {
						if (p.value[i + 1]) {
							continue;
						} else {
							boolean visit2[] = new boolean[visit.length];
							for (int j = 0; j < p.value.length; j++) {
								visit2[j] = p.value[j];
							}
							visit2[i + 1] = true;
							StringBuilder sb = new StringBuilder();
							sb.append(p.now).append(tickets[i][1]);
							q.add(new Place(tickets[i][1], visit2, sb.toString()));
						}
					}
				}
			}
		}
//		System.out.println(list);
		Collections.sort(list);
//		System.out.println(list);
		answer = new String[visit.length];
		int idx = 0;
		for (int i = 0; i < list.get(0).length(); i += 3) {
			answer[idx] = list.get(0).substring(i, i + 3);
			idx++;
		}
		return answer;
	}

	static class Place {
		String name;
		boolean[] value;
		String now;

		public Place(String name, boolean[] value, String now) {
			super();
			this.name = name;
			this.value = value;
			this.now = now;
		}

		@Override
		public String toString() {
			return "[name=" + name + ", value=" + Arrays.toString(value) + ", now=" + now + "]";
		}

	}
}