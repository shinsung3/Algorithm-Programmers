import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Main_수식최대화 {

	public static void main(String[] args) {
//		String expression = "100-200*300-500+20";
		String expression = "999-999+999*987";
		long a = solution(expression);
		System.out.println(a);
	}

	static long solution(String expression) {
		HashSet<Character> set = new HashSet<Character>();
		StringBuilder sb = new StringBuilder();
		list = new ArrayList<>();
		for (int i = 0; i < expression.length(); i++) {
			char ch = expression.charAt(i);
			if (ch < '0' || ch > '9') {
				set.add(ch);
				list.add(sb.toString());
				list.add(Character.toString(ch));
				sb = new StringBuilder();
			} else {
				sb.append(ch);
			}
		}
		list.add(sb.toString());
		Object[] calculate = set.toArray();
//		System.out.println(list);
		perm(calculate, 0);
		return answer;
	}

	static List<String> list;
	static long answer;

	static void perm(Object[] calculate, int idx) {
		if (idx == calculate.length) {
			List<String> copyList = new ArrayList<String>();
			for (int i = 0; i < list.size(); i++) {
				copyList.add(list.get(i));
			}
			System.out.println(Arrays.toString(calculate));
//			System.out.println(copyList);
			long value = 0;
			for (int i = 0; i < calculate.length; i++) {
				int j = 0;
				while (true) {
					if (j >= copyList.size())
						break;
					if (copyList.get(j).equals(calculate[i].toString())) {
						long value1 = Long.parseLong(copyList.get(j - 1));
						long value2 = Long.parseLong(copyList.get(j + 1));
						if (calculate[i].toString().equals("+")) {
							value = value1 + value2;
						} else if (calculate[i].toString().equals("*")) {
							value = value1 * value2;
						} else {
							value = value1 - value2;
						}
						copyList.remove(j - 1);
						copyList.remove(j - 1);
						copyList.remove(j - 1);
						copyList.add(j - 1, Long.toString(value));
//						System.out.println(copyList);
					} else {
						j++;
					}
				}
			}
			if (answer < Math.abs(value)) {
				answer = Math.abs(value);
			}

			return;
		}

		for (int i = idx; i < calculate.length; i++) {
			swap(idx, i, calculate);
			perm(calculate, idx + 1);
			swap(idx, i, calculate);
		}
	}

	static void swap(int i, int j, Object[] arr) {
		Object temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}