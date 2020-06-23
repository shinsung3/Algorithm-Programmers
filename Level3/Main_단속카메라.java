import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main_단속카메라 {
	public static void main(String[] args) {
		int[][] arr = { { -20, 15 }, { -14, -5 }, { -18, -13 }, { -5, -3 } };
		int a = solution(arr);
		System.out.println(a);
	}

	static int solution(int[][] routes) {
		int answer = 1;
		List<Route> list = new ArrayList<>();
		for (int[] a : routes)
			list.add(new Route(a[0], a[1]));
		Collections.sort(list, new Comparator<Route>() {
			@Override
			public int compare(Route o1, Route o2) {
				if (o1.start > o2.start)
					return 1;
				else if (o1.start == o2.start)
					return 0;
				else
					return -1;
			}
		});

		Route r = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			Route cur = list.get(i);
			if (r.end > cur.end) {
				r = cur;
			} else if (r.end < cur.start) {
				answer++;
				r = cur;
			}
		}

		return answer;
	}

	static class Route {
		int start;
		int end;

		public Route(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public String toString() {
			return "[start=" + start + ", end=" + end + "]";
		}
	}
}
