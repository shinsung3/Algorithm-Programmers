import java.util.Arrays;

public class Main_문자열다루기기본 {

	public static void main(String[] args) {
		String s = "**a123";
		boolean c = solution(s);
		System.out.println(c);
	}

	static boolean solution(String s) {
		boolean answer = true;

		if (s.length() == 4 || s.length() == 6) {

			for (int i = 0; i < s.length(); i++) {

				if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
					continue;
				} else {
					answer = false;
					break;
				}
			}
		} else {
			answer = false;
		}
		return answer;
	}
}