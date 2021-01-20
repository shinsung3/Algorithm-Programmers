import java.util.Arrays;
import java.util.HashSet;

public class Main_두개뽑아서더하기 {
	public static void main(String[] args) {
//		int[] numbers = { 2, 1, 3, 4, 1 };
		int[] numbers = { 5, 0, 2, 7 };
		int[] arr = solution(numbers);
		System.out.println(Arrays.toString(arr));
	}

	public static int[] solution(int[] numbers) {
		int[] answer = {};
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				set.add(numbers[i] + numbers[j]);
			}
		}
		answer = new int[set.size()];
		int idx = 0;
		for (int a : set) {
			answer[idx] = a;
			idx++;
		}
		Arrays.sort(answer);
		return answer;
	}
}