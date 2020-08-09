import java.util.Arrays;

public class Main_자물쇠와열쇠 {

	public static void main(String[] args) {
		int[][] key = { { 0, 0, 0 }, { 1, 0, 0 }, { 0, 1, 1 } };
		int[][] lock = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
		boolean a = solution(key, lock);
		System.out.println(a);
	}

	static boolean solution(int[][] key, int[][] lock) {
		boolean answer = false;
		// 1. turn 4
		// 2. make a padding
		int a = 1;
		int length = key.length - 1;
		int len = (length) * 2 + lock.length;
		int[][] map = new int[len][len];
		for (int i = length; i < length + lock.length; i++) {
			for (int j = length; j < length + lock.length; j++) {
				map[i][j] = lock[i - length][j - length];
			}
		}

		out: for (int iii = 0; iii < 4; iii++) {
//			System.out.println(iii);
			key = turn(key);
//			for (int[] aa : key)
//				System.out.println(Arrays.toString(aa));
//			System.out.println();

			for (int i = 0; i < map.length - key.length + 1; i++) {
				for (int j = 0; j < map[0].length - key[0].length + 1; j++) {
					boolean flag = false;
					boolean oneAndone = false;
					// 1이 있으면 맞지 않는것. 처음 낄때는 딱 맞아야 함.
					out1: for (int ii = 0; ii < key.length; ii++) {
						for (int jj = 0; jj < key.length; jj++) {
							if (map[ii + i][jj + j] == 1 && key[ii][jj] == 0) {
								continue;
							}
							if (map[ii + i][jj + j] == 1 && key[ii][jj] == 1) {
								oneAndone = true;
								break out1;
							}
							if (map[ii + i][jj + j] == 0)
								map[ii + i][jj + j] = key[ii][jj];
						}
					}
					// 0이 하나라도 있으면 맞지 않는것
					out1: for (int ii = length; ii < length + lock.length; ii++) {
						for (int jj = length; jj < length + lock.length; jj++) {
							if (map[ii][jj] == 0) {
								flag = true;
								break out1;
							}
						}
					}
//					for (int[] aa : map)
//						System.out.println(Arrays.toString(aa));
//					System.out.println();

					if (!flag && !oneAndone) {
						answer = true;
						break out;
					}
					// 다시 원상복귀
					map = new int[len][len];
					for (int ii = length; ii < length + lock.length; ii++) {
						for (int jj = length; jj < length + lock.length; jj++) {
							map[ii][jj] = lock[ii - length][jj - length];
						}
					}
				}
			}
		}
		return answer;
	}

	static int[][] turn(int[][] key) {
		int[][] turnMap = new int[key.length][key.length];
		for (int i = 0; i < key.length; i++) {
			for (int j = 0; j < key.length; j++) {
				if (key[i][j] == 1) {
					key[i][j] = 2;
				}
				turnMap[j][key.length - i - 1] = key[i][j];
			}
		}
		return turnMap;
	}
}