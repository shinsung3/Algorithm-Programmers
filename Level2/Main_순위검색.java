import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main_순위검색 {
	public static void main(String[] args) {
		String[] info = { "java backend junior pizza 150", "python frontend senior chicken 210",
				"python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
				"python backend senior chicken 50" };
		String[] query = { "java and backend and junior and pizza 100",
				"python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
				"- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150" };
		System.out.println(Arrays.toString(solution(info, query)));
		String s = s +"";
		System.out.println(s);
	}

	static int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("-", 0);
		map.put("cpp", 1);
		map.put("java", 2);
		map.put("python", 3);

		map.put("backend", 1);
		map.put("frontend", 2);

		map.put("junior", 1);
		map.put("senior", 2);

		map.put("chicken", 1);
		map.put("pizza", 2);

		// 1. 언어 - 파트 - 경력 - 음식 순으로 ("-")포함하여 list 만들기.
		List<Integer>[][][][] list = new ArrayList[4][3][3][3];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					for (int l = 0; l < 3; l++) {
						list[i][j][k][l] = new ArrayList<Integer>();
					}
				}
			}
		}

		// 2.
		for (int i = 0; i < info.length; i++) {
			String[] temp = info[i].split(" ");
			int a = map.get(temp[0]);
			int b = map.get(temp[1]);
			int c = map.get(temp[2]);
			int d = map.get(temp[3]);
			int score = Integer.parseInt(temp[4]);
//			System.out.println(a+" "+b+" "+c+" "+d+" "+score);
//			System.out.println();
			for (int j = 0; j <= a; j+=a) {
				for (int k = 0; k <= b; k+=b) {
					for (int l = 0; l <= c; l+=c) {
						for (int m = 0; m <= d; m+=d) {
//							System.out.println(j+" "+k+" "+l+" "+m);
//							System.out.println(list[j][k][l][m]);
							list[j][k][l][m].add(score);
						}
					}
				}
			}
		}

		for (int j = 0; j < 4; j++) {
			for (int k = 0; k < 3; k++) {
				for (int l = 0; l < 3; l++) {
					for (int m = 0; m < 3; m++) {
						Collections.sort(list[j][k][l][m]);
					}
				}
			}
		}

		// 3. 이진탐색 - lowerBound를 이용해서 탐색해서 시간을 줄이면 효율성을 맞출 수 있다.
		int idx = 0;
		for (int i = 0; i < query.length; i++) {
			String[] temp = query[i].split(" and ");
			String[] scoreTemp = temp[3].split(" ");
			int a = map.get(temp[0]);
			int b = map.get(temp[1]);
			int c = map.get(temp[2]);
			int d = map.get(scoreTemp[0]);
			int score = Integer.parseInt(scoreTemp[1]);
			int start = 0;
			int end = list[a][b][c][d].size();

			while (start < end) {
				int mid = (start + end) >> 1;
				if (list[a][b][c][d].get(mid) < score) {
					start = mid + 1;
				} else {
					end = mid;
				}
			}
			answer[idx] = list[a][b][c][d].size() - end;
			idx++;
		}

		
		return answer;
	}
}
