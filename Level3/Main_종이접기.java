import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main_종이접기 {

	public static void main(String[] args) {
		int n = 4;
		int a[] = solution(n);
		System.out.println(Arrays.toString(a));
	}

	static int[] solution(int n) {
		int[] answer = {};
		List<Integer> list = new ArrayList<Integer>();
		list.add(0);
		if (n == 1) {
			answer = new int[1];
			answer[0] = 0;
			return answer;
		}

		for (int i = 1; i < n; i++) {
			int len = list.size();
			int idx = list.size();
			list.add(0);
			for (int j = 0; j < len; j++) {
				idx--;
				if (list.get(idx) == 0)
					list.add(len + j + 1, 1);
				else
					list.add(len + j + 1, 0);
			}
		}
		answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}
}