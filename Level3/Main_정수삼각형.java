public class Main_정수삼각형 {

	public static void main(String[] args) {
		int n[][] = { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };
		int a = solution(n);
		System.out.println(a);
	}

	public static int solution(int[][] triangle) {
		int answer = 0;
		for (int i = 1; i < triangle.length; i++) {
			for (int j = 0; j < triangle[i].length; j++) {
				if (j == 0)
					triangle[i][j] = triangle[i][j] + triangle[i - 1][j];
				else if (j == triangle[i].length - 1) {
					triangle[i][j] = triangle[i][j] + triangle[i - 1][j - 1];
				} else {
					triangle[i][j] = Math.max(triangle[i][j] + triangle[i - 1][j],
							triangle[i][j] + triangle[i - 1][j - 1]);
				}
			}
		}

		for (int i = 0; i < triangle.length; i++) {
			answer = Math.max(triangle[triangle.length - 1][i], answer);
		}

		return answer;
	}
}