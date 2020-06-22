public class Main_가장긴펠린드롬 {

	public static void main(String[] args) {
//		String s = "abcdcba";
		String s = "aabbbbbb";
		int a = solution(s);
		System.out.println(a);
	}

	static int solution(String s) {
		int answer = 0;

		int idx = 1;
		int left = 0;
		int right = 0;
		if(s.length()==2) {
			if(s.charAt(0)==s.charAt(1))
				return 2;
			else
				return 1;
		}
		
		if(s.length()==3) {
			if(s.charAt(0)==s.charAt(2))
				return 3;
			if(s.charAt(0)==s.charAt(1)||s.charAt(1)==s.charAt(2))
				return 2;
			return 1;
				
		}
		
		if(s.length()==1)
			return 1;
		// 홀수 확인
		while (true) {
			left = idx;
			right = idx;
			int cnt = 1;
			while (true) {
				left--;
				right++;
				if (left < 0 || right >= s.length()) {
					break;
				}
				if (s.charAt(left) == s.charAt(right)) {
					cnt += 2;
				} else {
					break;
				}
			}
			if (cnt > 1) {
				if(answer<cnt)
					answer = cnt;
			} else {
				if(s.charAt(idx)==s.charAt(idx+1) || s.charAt(idx)==s.charAt(idx-1)) {
					cnt++;
				}
				if(answer<cnt)
					answer = cnt;
			}
			idx++;

			if (idx == s.length() - 1) {
				break;
			}
		}

		// 짝수 확인
		idx = 1;
		left = 0;
		right = 0;
		while (true) {
			left = idx;
			right = idx + 1;
			int cnt = 0;
			if (s.charAt(idx) == s.charAt(idx + 1)) {
				cnt=2;
				while (true) {
					left--;
					right++;
					if (left < 0 || right >= s.length()) {
						break;
					}
					if (s.charAt(left) == s.charAt(right)) {
						cnt += 2;
					} else {
						break;
					}
				}
			}
			idx++;
			if (cnt > 2) {
				if(answer<cnt)
					answer = cnt;
			}

			if (idx == s.length() - 2) {
				break;
			}
		}

		return answer;
	}
}