import java.util.Arrays;

class Solution {
	public int solution(int[] nums) {
		int answer = -1;
		Arrays.sort(nums);

		boolean flag = false;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] % 2 == 0) {
				continue;
			} else {
				flag = true;
				break;
			}
		}

		if (!flag) {
			answer = 0;
		} else {

			boolean[] arr = new boolean[3001];

			arr[1] = true;
			for (int i = 2; i < arr.length; i++) {
				for (int j = 2; j * i < arr.length; j++) {
					arr[i * j] = true;
				}
			}

//			System.out.println(Arrays.toString(arr));
			findCombi(nums, arr);
			answer = ans;
		}

		return answer;
	}

	static int ans;

	static void findCombi(int[] nums, boolean[] arr) {
		for (int i = 0; i < nums.length - 2; i++) {
			for (int j = i + 1; j < nums.length - 1; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					if (nums[i] % 2 == 0 && nums[j] % 2 == 0 && nums[k] % 2 == 0) {
						continue;
					} else {
						int sum = nums[i] + nums[j] + nums[k];
						if (!arr[sum]) {
							ans++;
						}
					}
				}
			}
		}
	}

}