public class Main {

	public static void main(String[] args) {
		int n = 10;
		String a = solution(n);
		System.out.println(a);
	}

	public static String solution(int n) {
		String answer = "";
		for(int i=0; i<n; i++) {
			answer += (i%2==0) ? "수" : "박";
		}
		return answer;
	}

	private static String src = "1\r\n" + "4 4\r\n" + "0 0 0 0\r\n" + "1 0 0 0\r\n" + "0 0 1 0\r\n" + "0 1 0 0";

}