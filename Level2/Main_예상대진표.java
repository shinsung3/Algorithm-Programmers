public class Main_예상대진표 {
	public static void main(String[] args) {
		int b = 8;
		int c = 3;
		int d = 2;

		int a = solution(b, c, d);

		System.out.println(a);
	}

	static int solution(int n, int a, int b) {
		int answer = 1;

		while (true) {
			int aKey = 0;
			int bKey = 0;
			if (a % 2 == 0) {
				aKey = a / 2;
			} else {
				aKey = a / 2 + 1;
			}
			if (b % 2 == 0) {
				bKey = b / 2;
			} else {
				bKey = b / 2 + 1;
			}

			if (bKey == aKey) {
				break;
			}
			a = aKey;
			b = bKey;
			answer++;
		}

		return answer;
	}
}