public class Main_콜라츠추측 {

	public static void main(String[] args) {
		int n = 1;
		int c = solution(n);
		System.out.println(c);
	}

	static int solution(int num) {
		boolean isOne = false;
		int answer = 0;
		long num1 = num;
		if (num1 != 1) {
			for (int i = 1; i <= 500; i++) {
				if (num1 % 2 == 0) {
					num1 /= 2;
					answer++;
				} else {
					num1 = num1 * 3 + 1;
					answer++;
				}

				if (num1 == 1) {
					isOne = true;
					break;
				}
			}
		}else {
			isOne = true;
		}

		if (isOne) {
			return answer;
		} else {
			return -1;
		}
	}
}