
public class Main {
	public static void main(String[] args) {
		int[] absolutes = {4,7,12};
		boolean[] signs = {true,false,true};
		int answer = solution(absolutes, signs);
		System.out.println(answer);
	}

	static int solution(int[] absolutes, boolean[] signs) {
		int answer = 0;
		for(int i=0; i<absolutes.length; i++) {
			if(signs[i]) {
				answer+=absolutes[i];
			}else {
				answer-=absolutes[i];
			}
		}
		return answer;
	}
}
