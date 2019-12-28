public class Main {

	public static void main(String[] args) {
		String n = "01033334444";
		System.out.println(solution(n));

	}

	public static String solution(String phone_number) {
		StringBuilder answer = new StringBuilder();
		int cnt=0;
		for(int i=phone_number.length()-1; i>=0; i--) {
			if(cnt<=3) {
				answer.append(phone_number.charAt(i));
			}else {
				answer.append("*");
			}
			cnt++;
		}
		return answer.reverse().toString();
	}

}
