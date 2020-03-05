import java.util.ArrayList;

class Solution {
	public int[] solution(int[] progresses, int[] speeds) {
		ArrayList<Integer> answerList = new ArrayList<>();
		ArrayList<Integer> arrList = new ArrayList<>();

		for (int i = 0; i < progresses.length; i++) {
			int value = 100 - progresses[i];
			int temp = value / speeds[i];
			if (value % speeds[i] != 0) {
				temp += 1;
			}
			arrList.add(temp);
		}

		int cnt = 1;
		int j = 0;
		while (true) {
			if (arrList.get(j) >= arrList.get(j + 1)) {
				arrList.remove(j + 1);
				cnt++;
			} else {
				j++;
				answerList.add(cnt);
				cnt = 1;
			}

			if (arrList.size() - 1 == j) {
				answerList.add(cnt);
				break;
			}
		}

		// int형 배열로 변환
		int[] answer = new int[answerList.size()];
		for (int i = 0; i < answerList.size(); i++) {
			answer[i] = answerList.get(i);
		}
		return answer;
	}
}