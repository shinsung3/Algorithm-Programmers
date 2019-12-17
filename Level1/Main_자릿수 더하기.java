import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		int N = 987;
		System.out.println(solution(N));

	}

	public static int solution(int n) {
		int answer = 0;
		StringBuilder sb = new StringBuilder();
		sb.append(n);
		
		for(int i=0; i<sb.toString().length(); i++) {
			answer += sb.toString().charAt(i)-'0';
		}

		return answer;
	}

	private static String src = "5\r\n" + "8 9 1 2 10";

}
