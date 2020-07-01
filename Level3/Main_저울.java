import java.util.Arrays;

public class Main_저울 {

	public static void main(String[] args) {
		int n[] = { 1, 2, 3 };
		int a = solution(n);
		System.out.println(a);
	}

	public static int solution(int[] weight) {
		int answer = 0;

		Arrays.sort(weight);
		int totalWeight = 1;
		for (int i = 0; i < weight.length; i++) {
			if (totalWeight - weight[i] >= 0) {
				totalWeight += weight[i];
			} else {
				break;
			}
		}
		answer = totalWeight;
		return answer;
	}
}