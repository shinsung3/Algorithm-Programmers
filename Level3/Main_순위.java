public class Main_순위 {

	public static void main(String[] args) {
		int n = 5;
		int[][] j = { { 4, 3 }, { 4, 2 }, { 1, 2 }, { 3, 2 }, { 2, 5 } };
		int a = solution(n, j);
		System.out.println(a);
	}

	static int solution(int n, int[][] results) {
		int answer = 0;
		// * 자신보다 앞쪽의 간선이 n-1일 경우 자신의 위치가 정해진다.
		int[][] arr = new int[n+1][n+1];
		int max = 101;

		// 1. 전체를 최대값으로 설정하고 자기가 자신에게 갈 순 없으니 0으로 설정
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (i == j)
					arr[i][j] = 0;
				else
					arr[i][j] = max;
			}
		}

		// 2. 그 외 값들을 추가.
		for (int i = 0; i < results.length; i++) {
			arr[results[i][0]][results[i][1]] = 1;
		}

		// 3. 플로이드 와샬은 DP기반
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
				}
			}
		}
		
		for(int i = 1; i <= n; i++){
            boolean flag = true;
            for(int j = 1; j <=n; j++) {
                if(i == j) continue;
				if (arr[i][j] == max && arr[j][i] == max) {
                    flag = false;
                    break;
                }
            }
            if(flag) answer++;
        }
        return answer;
	}
}