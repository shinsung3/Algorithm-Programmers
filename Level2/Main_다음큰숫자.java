public class Main_비밀지도 {

	public static void main(String[] args) {
		int n = 15;
		int c = solution(n);
		System.out.println(c);
	}

	static int solution(int n) {
		int answer = 0;
		String binary = Integer.toBinaryString(n);
		int cnt = 0;
		for(int i=0; i<binary.length(); i++) {
			if(binary.charAt(i)=='1')
				cnt++;
		}
		for(int i=n+1; i<=1000000; i++) {
			int count = 0;
			String bi = Integer.toBinaryString(i);
			boolean flag = false;
			for(int j=0; j<bi.length(); j++) {
				if(bi.charAt(j)=='1') {
					count++;
					if(count>cnt) {
						flag = true;
						break;
					}
				}
			}
			if(!flag) {
				if(count==cnt) {
					answer = i;
					break;
				}
			}
		}
		
		return answer;
	}
}