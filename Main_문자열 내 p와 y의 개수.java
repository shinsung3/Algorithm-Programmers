import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);
		String s = "pyY";
		System.out.println(solution(s));
	}

	public static boolean solution(String s) {
		boolean answer = true;
		int p_cnt=0;
		int y_cnt=0;
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i)=='p' || s.charAt(i)=='P') {
				p_cnt++;
			}
			if(s.charAt(i)=='y' || s.charAt(i)=='Y') {
				y_cnt++;	
			}
		}
		
		if(p_cnt==y_cnt) {
			answer = true;
		}else {
			answer = false;
		}

		return answer;
	}

	private static String src = "8\r\n" + "5 4 3 2 1 6 7 8";
}
