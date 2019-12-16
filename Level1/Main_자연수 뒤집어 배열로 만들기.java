import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		long n = 12345;
		solution(n);
		
	}

	public static int[] solution(long n) {
		StringBuilder sb = new StringBuilder();
		sb.append(n);
		int[] answer = new int[sb.toString().length()];
		int idx=0;
		for(int i=sb.toString().length()-1; i>=0; i--) {
			answer[idx] = sb.toString().charAt(i)-'0';
			idx++;
		}
		System.out.println(Arrays.toString(answer));
		return answer;
	}

}
