public class Main {

	public static void main(String[] args) {

		int num = 4;
		System.out.println(solution(num));
	}

	public static String solution(int num) {
		StringBuilder sb = new StringBuilder();
		if (num % 2 == 0) {
			sb.append("Even");
		} else {
			sb.append("Odd");
		}
		return sb.toString();
	}
}
