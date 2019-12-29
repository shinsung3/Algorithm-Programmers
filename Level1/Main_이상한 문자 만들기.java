public class Main {

	public static void main(String[] args) {
		String s = "tr yyoQ3 w h e l l O world  ";
		solution(s);
	}

	static String solution(String s) {
		StringBuilder answer = new StringBuilder();
		int idx = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ' ') {
				if (idx % 2 == 0) { // 대문자
					if (s.charAt(i) > 'a' && s.charAt(i) < 'z') {
						char temp = (char) (s.charAt(i) - ('a' - 'A'));
						answer.append(temp);
					} else {
						answer.append(s.charAt(i));
					}
				} else { // 소문자
					if (s.charAt(i) > 'A' && s.charAt(i) < 'Z') {
						char temp = (char) (s.charAt(i) + ('a' - 'A'));
						answer.append(temp);
					} else {
						answer.append(s.charAt(i));
					}
				}
				idx++;
			} else {
				answer.append(" ");
				idx = 0;
			}
		}
		System.out.println(answer.toString());
		return answer.toString();
	}

	private static String src = "1\r\n" + "4 4\r\n" + "0 0 0 0\r\n" + "1 0 0 0\r\n" + "0 0 1 0\r\n" + "0 1 0 0";

}