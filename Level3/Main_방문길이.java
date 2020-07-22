import java.util.HashSet;

public class Main_방문길이 {

	public static void main(String[] args) {
		String dirs = "LLLLLLLLLLLLLLLLLLLLLLLLLLRRRRRRRRRRRRRRRRRRRR";
		int a = solution(dirs);
		System.out.println(a);
	}

	static int solution(String dirs) {
		int answer = 0;
		int y = 0;
		int x = 0;
		int sy = y;
		int sx = x;
		boolean flag = false;
		HashSet<String> set = new HashSet<String>();
		for (int i = 0; i < dirs.length(); i++) {
			if (dirs.charAt(i) == 'U') {
				y++;
				if (y > 5) {
					y--;
					continue;
				}
			} else if (dirs.charAt(i) == 'D') {
				y--;
				if (y < -5) {
					y++;
					continue;
				}
			} else if (dirs.charAt(i) == 'L') {
				x--;
				if (x < -5) {
					x++;
					continue;
				}
			} else if (dirs.charAt(i) == 'R') {
				x++;
				if (x > 5) {
					x--;
					continue;
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append(sx).append(sy).append("->").append(x).append(y);
			StringBuilder sb1 = new StringBuilder();
			sb1.append(x).append(y).append("->").append(sx).append(sy);

//			System.out.println(sb.toString());
//			System.out.println(sb1.toString());
			if (set.contains(sb.toString()) || set.contains(sb1.toString())) {
				flag = true;
			} else {
				set.add(sb.toString());
				set.add(sb1.toString());
				flag = false;
			}
			sx = x;
			sy = y;
//			System.out.println(set.size());
		}
//		System.out.println(set);
		answer = set.size() / 2;

		return answer;
	}
}