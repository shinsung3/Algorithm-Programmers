public class Main {

	public static void main(String[] args) {
		String s = "aabbaccc";
		int c = solution(s);
		System.out.println(c);
	}

	static int solution(String s) {
		int answer = s.length();
		for (int i = 1; i <= s.length() / 2; i++) {
			int cnt = 1;
			String start = "";
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < s.length() / i; j++) {
				String compare = s.substring((i * j), (i * j) + i);
				if (start.equals(compare)) {
					cnt++;
					continue;
				}
				if (cnt > 1) {
					sb.append(cnt).append(start);
				} else {
					sb.append(start);
				}
				start = compare;
				cnt = 1;
			}
			if (cnt > 1) {
				sb.append(cnt).append(start);
			} else {
				sb.append(start);
			}

			// 내가 쪼갤 숫자로 정확히 문자열이 안나눠진다면
			if (s.length() % i != 0) {
				sb.append(s.substring(s.length() - (s.length() % i), s.length()));
			}

			answer = Math.min(answer, sb.toString().length());
		}

		return answer;
	}
}