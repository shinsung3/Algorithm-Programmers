public class Main_괄호변환 {

	public static void main(String[] args) {
		String p = "()))((()";
		String a = solution(p);
		System.out.println(a);
	}

	static String solution(String p) {
		if (!isBalanced(p) && p.length() == 0) {
			return "";
		}
		if(isCollected(p)) {
			return p;
		}
		String answer = ans(p);
		return answer;
	}

	// 2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야
	// 하며, v는 빈 문자열이 될 수 있습니다.
	static String ans(String p) {
		if (p.length() == 0) {
			return "";
		}

		// 2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다.
		int pivot = findDivisionPoint(p);
		String u = p.substring(0, pivot + 1);
		String v = p.substring(pivot + 1);

		System.out.println("u: " +u);
		System.out.println("v: " + v);
		System.out.println();
		// 3. 문자열 u가 "올바른 괄호 문자열"이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
		if (isCollected(u)) {
			return u + ans(v);
		} else {
			String temp = "(" + ans(v) + ")";

			StringBuilder sb = new StringBuilder();
			for (int i = 1; i < u.length() - 1; i++) {
				if (u.charAt(i) == '(')
					sb.append(")");
				else
					sb.append("(");
			}
			System.out.println("자르고, 뒤집기 전 :  "+ u);
			System.out.println("앞뒤를 자르고 뒤집은 후 :  " +sb.toString());
			System.out.println("둘이 합친 결과 :  "+temp + sb.toString());
			return temp + sb.toString();
		}
	}

	static boolean isCollected(String w) {
		if (w.charAt(0) != '(') {
			return false;
		}
		int check = 0;
		for (int i = 0; i < w.length(); i++) {
			if (w.charAt(i) == ')') {
				check--;
			} else
				check++;
			if (check < 0)
				return false;
		}
		return true;
	}

	static int findDivisionPoint(String w) {
		int check = 0;
		for (int i = 0; i < w.length(); i++) {
			if (w.charAt(0) == '(') {
				if (w.charAt(i) == ')') {
					check--;
				} else
					check++;
				if (check == 0)
					return i;
			} else {
				if (w.charAt(i) == '(') {
					check--;
				} else
					check++;
				if (check == 0)
					return i;
			}
		}
		return check;
	}

	// 균형잡힌 문자열 만들기.
	static boolean isBalanced(String w) {
		int check = 0;
		for (int i = 0; i < w.length(); i++) {
			if (w.charAt(i) == ')') {
				check--;
			} else
				check++;
		}

		if (check == 0)
			return true;
		else
			return false;
	}
}
