import java.util.Arrays;

public class Main_숫자야구 {
	public static void main(String[] args) {
		int[][] num = { { 123, 1, 1 }, { 356, 1, 0 }, { 327, 2, 0 }, { 489, 0, 1 } };
		int a = solution(num);
		for (int[] b : num)
			System.out.println(Arrays.toString(b));
		System.out.println(a);
	}

	public static int solution(int[][] baseball) {
		int answer = 0;

		int[] nums = new int[9];
		for (int i = 0; i < 9; i++) {
			nums[i] = i + 1;
		}
		perm(nums, 0, 3, nums.length, baseball);
		answer = ans;
		return answer;
	}

	// 1. 순열로 나올 수 있는 전체의 숫자 조합을 짠다.
	static int ans;

	static void perm(int[] nums, int idx, int r, int n, int[][] baseball) {
		if (idx == r) {
			int[] numbers = new int[3];
			for (int i = 0; i < r; i++) {
				numbers[i] = nums[i];
			}

			compare(numbers, baseball);
			return;
		}

		for (int i = idx; i < n; i++) {
			swap(i, idx, nums);
			perm(nums, idx + 1, r, n, baseball);
			swap(i, idx, nums);
		}
	}

	static void swap(int a, int b, int[] nums) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}

	// 2. 나온 숫자를 가지고 비교를 해본다.
	static void compare(int[] nums, int[][] baseball) {
		boolean flag = false;
		for (int i = 0; i < baseball.length; i++) {
			String str = Integer.toString(baseball[i][0]);

			// 3. 스트라이크와 볼의 갯수가 같은지 비교해보자!
			int strike = baseball[i][1];
			int ball = baseball[i][2];
			int s = 0;
			int b = 0;

			for (int j = 0; j < str.length(); j++) {
				for (int k = 0; k < str.length(); k++) {
					if (str.charAt(j) - '0' == nums[k]) {
						if (k == j) {
							s++;
						} else {
							b++;
						}
					}
				}
			}
			if (strike != s || ball != b) {
				flag = true;
				break;
			}
		}
		if (!flag) {
			ans++;
		}
	}
}