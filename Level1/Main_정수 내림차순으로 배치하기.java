import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		long n = 118372;
		long a = solution(n);
		System.out.println(a);
	}

	static long solution(long n) {
		long answer = 0;
		StringBuilder sb = new StringBuilder();
		sb.append(n);
		char arr[] = sb.toString().toCharArray();
		
		Arrays.sort(arr);
		
		sb = new StringBuilder();
		for(int i=arr.length-1; i>=0; i--) {
			sb.append(arr[i]);
		}
		
		answer = Long.parseLong(sb.toString());
		
		return answer;
	}

	private static String src = "1\r\n" + "4 4\r\n" + "0 0 0 0\r\n" + "1 0 0 0\r\n" + "0 0 1 0\r\n" + "0 1 0 0";

}