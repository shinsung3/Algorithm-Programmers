public class Main_하샤드수 {

	public static void main(String[] args) {
		int n = 10;
		boolean c = solution(n);
		System.out.println(c);
	}

	static boolean solution(int x) {
		boolean answer = true;

		int sum = 0;
		int first = x;
		while (true) {
			if (x / 10 == 0) {
				sum+= x%10;
				break;
			}
			sum+= x%10;
			x/=10;
			
		}
		
		if(first%sum!=0) {
			answer = false;
		}

		return answer;
	}
}