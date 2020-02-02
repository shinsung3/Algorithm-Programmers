import java.util.Arrays;
import java.util.Comparator;

public class Main_실패율 {

	public static void main(String[] args) {
		int n = 500;
		int[] stages = { 4, 4, 4, 4, 4 };
		int[] c = solution(n, stages);
		System.out.println(Arrays.toString(c));
	}

	static int[] solution(int N, int[] stages) {
		sorting list[] = new sorting[N];
		int[] ans = new int[N];

		int people = stages.length;
		for (int i = 1; i <= N; i++) {
			int cnt = 0;
			for (int j = 0; j < stages.length; j++) {
				if (stages[j] == i) {
					cnt++;
				}
			}
			if (people == 0) {
				list[i - 1] = new sorting(-1, i);
			} else
				list[i - 1] = new sorting((double) cnt / (double) people, i);
			people -= cnt;
		}

		Arrays.sort(list, new Comparator<sorting>() {

			@Override
			public int compare(sorting o1, sorting o2) {
				if (o1.mean == o2.mean) {
					return o1.value - o2.value;
				} else {
					if (o1.mean - o2.mean < 0)
						return 1;
					else
						return -1;
				}
			}
		});


		for (int i = 0; i < N; i++) {
			ans[i] = list[i].value;
		}

		return ans;
	}

	static class sorting {
		double mean;
		int value;

		public sorting(double mean, int value) {
			super();
			this.mean = mean;
			this.value = value;
		}

		@Override
		public String toString() {
			return "sotring [mean=" + mean + ", value=" + value + "]";
		}

	}
}