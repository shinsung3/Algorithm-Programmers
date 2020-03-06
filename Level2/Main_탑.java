class Solution {
	public int[] solution(int[] heights) {
		int[] answer = new int[heights.length];

		for (int i = heights.length - 1; i >= 1; i--) {
			for (int j = i - 1; j >= 0; j--) {
				int a = heights[i];
				int b = heights[j];
				if (a < b) {
					answer[i] = j + 1;
					break;
				}
			}
		}

		return answer;
	}
}