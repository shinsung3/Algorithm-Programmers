public class Main_멀쩡한사각형 {
	public static void main(String[] args) {
		int w = 8;
		int h = 7;
		long a = solution(w, h);
		System.out.println(a);
	}

	static long solution(int w, int h) {
		long answer = 0;
		long min = (long)h;
		long max = (long)w;
		if (w < h) {
			min = (long)w;
			max = (long)h;
		}

		long value = 1;
		while (value > 0) {
			value = max % min;
			max = min;
			min = value;
		}

		answer = (long)w * (long)h - ((long)w + (long)h - max);
		return answer;
	}
}