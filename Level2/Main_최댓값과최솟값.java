import java.util.Arrays;

public class Main_최댓값과최솟값 {

	public static void main(String[] args) {
		String s = "-1 -2 -3 -4";
		String c = solution(s);
		System.out.println(c);
	}

	static String solution(String s) {
		String answer = "";
		String[] arr = s.split(" ");
		int[] integer = new int[arr.length];
		for(int i=0; i<arr.length; i++) {
			integer[i] = Integer.parseInt(arr[i]);
		}
		
		Arrays.sort(integer);
		answer += integer[0];
		answer += " "+integer[integer.length-1];
		return answer;
	}
}