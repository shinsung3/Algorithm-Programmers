import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main_불량사용자 {
	public static void main(String[] args) {
		String[] ui = { "frodo" };
		String[] bi = { "*****", "******" };
		int a = solution(ui, bi);
		System.out.println(a);
	}

	static int solution(String[] user_id, String[] banned_id) {
		hs = new HashSet<Set<String>>();
		dfs(new LinkedHashSet<String>(), user_id, banned_id, 0);
		return hs.size();
	}

	static Set<Set<String>> hs;
	static int cnt;

	static void dfs(LinkedHashSet<String> set, String[] user_id, String[] banned_id, int ii) {
		if (set.size() == banned_id.length) {
//			System.out.println(set);
			int idx = 0;
			boolean check = false;
			out: for (String str : set) {
				if (banned_id[idx].length() == str.length()) {
					for (int i = 0; i < banned_id[idx].length(); i++) {
						if (banned_id[idx].charAt(i) != '*') {
							if (banned_id[idx].charAt(i) == str.charAt(i)) {
								continue;
							} else {
								check = true;
								break out;
							}
						}
					}
					idx++;
				} else {
					check = true;
					break;
				}
			}
			if (!check) {
				hs.add(new HashSet<String>(set));
//				System.out.println(hs);
			}
			return;
		}
		for (String s : user_id) {
			if (!set.contains(s)) {
				set.add(s);
				dfs(set, user_id, banned_id, ii + 1);
				set.remove(s);
			}
		}
	}
}
