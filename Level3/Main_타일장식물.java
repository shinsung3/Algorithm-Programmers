public class Main_타일장식물 {

	public static void main(String[] args) {
		int n = 80;
		long a = solution(n);
		System.out.println(a);
	}

	static long solution(int N) {
		long answer = 0;
		long row = 1;
		long col = 1;
		for (int i = 1; i < N; i++) {
			int idx = i + 1;
			if (idx % 2 == 0) {
				row = row + col;
			} else {
				col = row + col;
			}
		}
		answer = row * 2 + col * 2;

		return answer;
	}
}