public class Main_서울에서김서방찾기 {

	public static void main(String[] args) {
		String[] str = {"Jane","K","Kim"};
		String s = solution(str);
		System.out.println(s);
	}

	static String solution(String[] seoul) {
		StringBuilder answer = new StringBuilder();
		answer.append("김서방은 ");
		
		for(int i=0; i<seoul.length; i++) {
			if(seoul[i].equals("Kim")) {
				answer.append(i);
			}
		}
		
		answer.append("에 있다");
		return answer.toString();
	}

}