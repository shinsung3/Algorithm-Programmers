import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_카카오프렌즈컬러링북 {
	public static void main(String[] args) {
		int m = 13;
		int n = 3;
		int[][] picture = {{1, 1, 1, 0}, {1, 1, 1, 0}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}};

		for (int[] a : picture)
			System.out.println(Arrays.toString(a));
		int[] a = solution(m, n, picture);
		System.out.println(Arrays.toString(a));
	}

	static int[] solution(int m, int n, int[][] picture) {
		int[] Y = { -1, 1, 0, 0 };
		int[] X = { 0, 0, -1, 1 };
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;
		boolean visit[][] = new boolean[m][n];
		Queue<Node> q = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int cnt = 0;
				if (!visit[i][j] && picture[i][j] > 0) {
					numberOfArea++;
					cnt++;
					q.add(new Node(i, j, picture[i][j]));
					visit[i][j] = true;
					while (!q.isEmpty()) {
						Node node = q.poll();

						for (int ii = 0; ii < 4; ii++) {
							int ny = node.y + Y[ii];
							int nx = node.x + X[ii];

							if (ny < 0 || nx < 0 || ny >= m || nx >= n)
								continue;
							if (visit[ny][nx])
								continue;
							if (picture[ny][nx] != node.value)
								continue;

							q.add(new Node(ny, nx, picture[ny][nx]));
							visit[ny][nx] = true;
							cnt++;
						}
					}
					maxSizeOfOneArea = Math.max(maxSizeOfOneArea, cnt);
//					System.out.println(numberOfArea + "<< 나눠지는 구역");
//					System.out.println(maxSizeOfOneArea + "<<현재 가장 크게 나눠지는 구역 ");
				}
			}
		}

		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		return answer;
	}

	static class Node {
		int y, x, value;

		public Node(int y, int x, int value) {
			super();
			this.y = y;
			this.x = x;
			this.value = value;
		}

		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + ", value=" + value + "]";
		}

	}
}