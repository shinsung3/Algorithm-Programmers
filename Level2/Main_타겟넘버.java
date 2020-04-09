import java.util.Arrays;

public class Main_타겟넘버 {
	public static void main(String[] args) {
		int[] num = { 1, 1, 1, 1, 1 };
		int t = 3;
		int a = solution(num, t);
		System.out.println(a);
	}

	static int answer;

	public static int solution(int[] numbers, int target) {
		combi(0, numbers.length, 0, new boolean[numbers.length], numbers, target);
		return answer;
	}

	// 1. 조합을 활용해서 5개 중 3개를 뽑는 걸 해본다. true면 + , false면 -
	static void combi(int cnt, int n, int index, boolean visit[], int[] numbers, int target) {

		if (n <= index) {
			int sum = 0;
			for (int i = 0; i < visit.length; i++) {
				if (visit[i]) {
					sum += numbers[i];
				} else {
					sum -= numbers[i];
				}
			}
			if (target == sum) {
				answer++;
			}
			return;
		}

		if (n <= cnt) {
			return;
		}

		visit[index] = true;
		combi(cnt + 1, n, index + 1, visit, numbers, target);
		visit[index] = false;
		combi(cnt, n, index + 1, visit, numbers, target);
	}
}