public class Main_3차_n진수게임 {
	public static void main(String[] args) {
		int n = 16;
		int t = 16;
		int m = 2;
		int p = 1;

		String a = solution(n, t, m, p);
		System.out.println(a);
	}

	static String solution(int n, int t, int m, int p) {
		StringBuilder sb = new StringBuilder();
		sb.append("0");
		for (int i = 1; i <= t * m; i++) {
			// 1. 진법 계산기
			String b = change(n, i);
			sb.append(b);
		}
		System.out.println(sb.toString());
		String answer = findNum(sb.toString(), m, p, t);
		return answer;
	}

	// 2. 튜브가 말한 숫자 찾기.
	static String findNum(String str, int m, int p, int t) {
		StringBuilder sb = new StringBuilder();
		p--;
		while (true) {
			sb.append(str.charAt(p));
			p += m;
			if (sb.length() == t)
				break;
		}
		return sb.toString();
	}

	// 1. 진법 계산기
	static String change(int n, int value) {
		int key = value;
		StringBuilder sb = new StringBuilder();
		while (value > 0) {
			int mok = value / n;
			int namugi = value % n;

			if (namugi >= 10) {
				if (namugi == 10)
					sb.append("A");
				else if (namugi == 11)
					sb.append("B");
				else if (namugi == 12)
					sb.append("C");
				else if (namugi == 13)
					sb.append("D");
				else if (namugi == 14)
					sb.append("E");
				else if (namugi == 15)
					sb.append("F");
			} else {
				sb.append(namugi);
			}
			value = mok;

		}
		return sb.reverse().toString();
	}
}