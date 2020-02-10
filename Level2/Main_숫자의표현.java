public class Main_숫자의표현 {

	public static void main(String[] args) {
		int s = 15;
		int c = solution(s);
		System.out.println(c);
	}

	static int solution(int n) {
		int answer = 0;
		for(int i = 1; i<=n; i++) {
			int sum = 0;
			boolean isCheck = false;
			for(int j=i; j<=n; j++) {
				sum += j;
				if(sum == n) {
					isCheck = true;
					break;
				}else if(sum >n)
					break;
			}
			if(isCheck)
				answer++;
		}
		return answer;
	}
}