import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main_파일명정렬 {
	public static void main(String[] args) {
		String[] m = { "img12323232323232.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG" };
		System.out.println(Arrays.toString(m));
		String[] a = solution(m);
		System.out.println(Arrays.toString(a));
	}

	static String[] solution(String[] files) {
		String[] answer = new String[files.length];

		// 1. 문자열 나누기 head, number
		ArrayList<Headnum> list = new ArrayList<>();
		for (int i = 0; i < files.length; i++) {
			StringBuilder sb = new StringBuilder();
			boolean first = false;
			int cnt = 0;
			Headnum hn = new Headnum();
			for (int j = 0; j < files[i].length(); j++) {
				// 2. 숫자가 나오기 전까지 계산
				if (files[i].charAt(j) >= '0' && files[i].charAt(j) <= '9') {
					if (!first) {
						hn.head = sb.toString();
						sb.delete(0, sb.length());
						first = true;
					}
					cnt++;
					sb.append(files[i].charAt(j));
					if (cnt >= 5)
						break;

				} else {
					if (first) {
						break;
					}
					sb.append(files[i].charAt(j));
				}
			}
			if (!first) {
				hn.head = sb.toString();
			} else {
				hn.num = Integer.parseInt(sb.toString());
			}
			hn.idx = i;
			list.add(hn);
		}

		Collections.sort(list, new Comparator<Headnum>() {

			@Override
			public int compare(Headnum o1, Headnum o2) {
				if (o1.head.toLowerCase().equals(o2.head.toLowerCase())) {
					return o1.num - o2.num;
				} else {
					return o1.head.toLowerCase().compareTo(o2.head.toLowerCase());
				}
			}
		});

		for (int i = 0; i < list.size(); i++) {
			answer[i] = files[list.get(i).idx];
		}

		return answer;
	}

	static class Headnum {
		String head;
		int num;
		int idx;

		public Headnum(String head, int num, int idx) {
			super();
			this.head = head;
			this.num = num;
			this.idx = idx;
		}

		public Headnum() {
		}

		@Override
		public String toString() {
			return "Headnum [head=" + head + ", num=" + num + ", idx=" + idx + "]";
		}

	}
}