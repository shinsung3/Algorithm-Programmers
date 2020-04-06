public class Main_124나라의숫자 {
	public static void main(String[] args) {
		int b = 19;
		String a = solution(b);
		System.out.println(a);
	}

	static String solution(int n) {
		String answer = "";

		int ii = n;
		while (ii > 0) {
			int front = ii % 3;
			ii /= 3;

			if (front == 0) {
				front = 4;
				ii--;
			}

			answer = Integer.toString(front) + answer;
		}
		return answer;
	}
}