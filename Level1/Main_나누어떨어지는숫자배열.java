import java.util.ArrayList;
import java.util.Arrays;

public class Main_나누어떨어지는숫자배열 {

	public static void main(String[] args) {
		int arr[] = { 3,2,6 };
		int divisor = 10;
		int c[] = solution(arr, divisor);
		System.out.println(Arrays.toString(c));
	}

	static int[] solution(int[] arr, int divisor) {

		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % divisor == 0) {
				list.add(arr[i]);
			}
		}

		int[] answer = {};
		if (list.size() != 0) {
			answer = new int[list.size()];
			for (int i = 0; i < answer.length; i++) {
				answer[i] = list.get(i);
			}
		}else {
			answer = new int[1];
			answer[0] = -1;
		}

		Arrays.sort(answer);

		return answer;
	}
}