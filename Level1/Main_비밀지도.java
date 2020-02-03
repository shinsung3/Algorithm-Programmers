import java.util.Arrays;
import java.util.Comparator;

public class Main_비밀지도 {

	public static void main(String[] args) {
		int n = 5;
		int[] arr1 = { 9, 20, 28, 18, 11 };
		int[] arr2 = { 30, 1, 21, 17, 28 };
		String[] c = solution(n, arr1, arr2);
		System.out.println(Arrays.toString(c));
	}

	static String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[arr1.length];
		char[][] chArray1 = new char[arr1.length][arr1.length];
		char[][] chArray2 = new char[arr1.length][arr1.length];
		for (int i = 0; i < arr1.length; i++) {
			String str = Integer.toBinaryString(arr1[i]);
			if (str.length() < arr1.length) {
				while (true) {
					str = "0" + str;
					if (str.length() == arr1.length)
						break;
				}
			}
			chArray1[i] = str.toCharArray();
		}

		for (int i = 0; i < arr2.length; i++) {
			String str = Integer.toBinaryString(arr2[i]);
			if (str.length() < arr2.length) {
				while (true) {
					str = "0" + str;
					if (str.length() == arr2.length)
						break;
				}
			}
			chArray2[i] = str.toCharArray();
		}
		for (int i = 0; i < chArray1.length; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < chArray1.length; j++) {
				if (chArray1[i][j] == '1' || chArray2[i][j] == '1') {
					sb.append("#");
					continue;
				}
				if(chArray1[i][j] =='0' && chArray2[i][j] =='0') {
					sb.append(" ");
					continue;
				}
			}
			answer[i] = sb.toString();
		}
		
		return answer;

	}
}