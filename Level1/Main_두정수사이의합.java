public class Main_두정수사이의합 {

	public static void main(String[] args) {
		int a = 5;
		int b = 3;
		long c = solution(a,b);
		System.out.println(c);
	}

	static long solution(int a, int b) {
		long answer = 0;
		if(a>b) {
			int temp = b;
			b = a;
			a = temp;
		}
		for(int i=a; i<=b; i++) {
			answer+=i;
		}
		return answer;
	}
}