import java.util.Arrays;

public class Main_문자열내림차순으로배치하기 {

	public static void main(String[] args) {
		String s = "Zbcdefg";
		String c = solution(s);
		System.out.println(c);
	}

	static String solution(String s) {
		char ch[] = s.toCharArray();
		Arrays.sort(ch);
		
		StringBuilder sb = new StringBuilder();
		for(int i=s.length()-1; i>=0; i--) {
			sb.append(ch[i]);
		}
		return sb.toString();
	}
}