import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main_가장큰수 {

	public static void main(String[] args) {
		int[] n = { 0, 0, 0, 0 };
		String a = solution(n);
		System.out.println(a);
	}

	public static String solution(int[] numbers) {
		String answer = "";
		List<Number> list = new ArrayList<>();

		boolean flag = false;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] != 0) {
				flag = true;
				break;
			}
		}

		if (flag) {
			for (int i = 0; i < numbers.length; i++) {
				StringBuilder sb = new StringBuilder();
				sb.append(numbers[i]);
				int idx = 0;
				while (true) {
					if (sb.length() == 4) {
						break;
					}
					sb.append(sb.toString().charAt(idx));
					idx++;
				}
				list.add(new Number(numbers[i], sb.toString()));
			}

			Collections.sort(list, new Comparator<Number>() {

				@Override
				public int compare(Number o1, Number o2) {
					return Integer.parseInt(o2.value) - Integer.parseInt(o1.value);
				}
			});

			System.out.println(list);

			for (int i = 0; i < list.size(); i++) {
				answer += list.get(i).key;
			}
			return answer;
		} else {
			return "0";
		}
	}

	static class Number {
		int key;
		String value;

		public Number(int key, String value) {
			super();
			this.key = key;
			this.value = value;
		}

		@Override
		public String toString() {
			return "Number [key=" + key + ", value=" + value + "]";
		}

	}
}