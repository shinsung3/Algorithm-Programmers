public class Main_단체사진찍기 {
	public static void main(String[] args) {
		int n = 2;
		String[] data = { "M~C<2", "C~M>1" };
		int a = solution(n, data);

		System.out.println(a);
	}

	static int solution(int n, String[] data) {

		data2 = new String[n];
		for (int i = 0; i < n; i++) {
			StringBuilder sb = new StringBuilder();
			int a = changeValue(data[i].charAt(0));
			int b = changeValue(data[i].charAt(2));
			char c = data[i].charAt(3);
			char d = data[i].charAt(4);
			sb.append(a).append(b).append(c).append(d);
			data2[i] = sb.toString();
		}

		position = new int[8];
		for (int i = 0; i < 8; i++) {
			position[i] = i;
		}
		count = 0;
		perm(0);

		return count;
	}

	static int[] position;
	static int count;
	static String[] data2;

	static int changeValue(char a) {
		if (a == 'A')
			return 0;
		if (a == 'C')
			return 1;
		if (a == 'F')
			return 2;
		if (a == 'J')
			return 3;
		if (a == 'M')
			return 4;
		if (a == 'N')
			return 5;
		if (a == 'R')
			return 6;
		else
			return 7;
	}

	static void perm(int idx) {

		if (idx == 8) {
			for (int i = 0; i < data2.length; i++) {
				int one = position[data2[i].charAt(0) - '0'];
				int two = position[data2[i].charAt(1) - '0'];
				char compare = data2[i].charAt(2);
				int diff = data2[i].charAt(3) - '0';
				if (compare == '>') {
					if (Math.abs(one - two) - 1 <= diff)
						return;
				} else if (compare == '<') {
					if (Math.abs(one - two) - 1 >= diff)
						return;
				} else {
					if (Math.abs(one - two) - 1 != diff)
						return;
				}
			}
			count++;
			return;
		}

		for (int i = idx; i < 8; i++) {
			swap(i, idx);
			perm(idx + 1);
			swap(i, idx);
		}
	}

	static void swap(int a, int b) {
		int temp = position[a];
		position[a] = position[b];
		position[b] = temp;
	}
}