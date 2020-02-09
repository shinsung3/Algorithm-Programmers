public class Main_올바른괄호 {

	public static void main(String[] args) {
		String s = "(()(";
		boolean c = solution(s);
		System.out.println(c);
	}

	static boolean solution(String s) {
		boolean answer = true;
		char[] arr = s.toCharArray();

		int front = 0;
		int check = 0;
		if (arr[0] != '(') {
			answer = false;
		} else {
			while (true) {
				if (arr[front] == '(') {
					check++;
				} else {
					check--;
				}
				front++;
				if (check < 0)
					break;
				if (front >= arr.length) {
					break;
				}
			}
		}

		if (check != 0)
			answer = false;

		return answer;
	}
}