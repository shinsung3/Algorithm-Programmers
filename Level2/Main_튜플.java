import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class Main_튜플 {
	public static void main(String[] args) {
		String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
		int[] a = solution(s);

		System.out.println(Arrays.toString(a));
	}

	static int[] solution(String s) {
		StringBuilder sb = new StringBuilder();
		ArrayList<int[]> list = new ArrayList<>();
		int cnt = 0;
		for (int i = 1; i < s.length() - 1; i++) {
			if (s.charAt(i) == '{') {
				continue;
			} else if (s.charAt(i) == '}') {
				if (s.charAt(i + 1) == ',') {
					i++;
				}
				String[] arr = sb.toString().split(",");
				int[] array = new int[cnt + 1];
				for (int j = 0; j < arr.length; j++) {
					array[j] = Integer.parseInt(arr[j]);
				}
				cnt = 0;
				list.add(array);
				sb = new StringBuilder();
				continue;
			} else {
				if (s.charAt(i) == ',')
					cnt++;
				sb.append(s.charAt(i));
			}
		}

		Collections.sort(list, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1.length > o2.length)
					return 1;
				else
					return -1;
			}

		});

		int[] answer = new int[list.size()];
		answer[0] = list.get(0)[0];
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(answer[0]);
		for (int i = 1; i < list.size(); i++) {
			for (int j = 0; j < list.get(i).length; j++) {
				if (!set.contains(list.get(i)[j])) {
					answer[i] = list.get(i)[j];
					set.add(answer[i]);
				}
			}
		}

		return answer;
	}
}