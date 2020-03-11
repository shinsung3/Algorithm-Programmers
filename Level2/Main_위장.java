import java.util.HashMap;

public class Main_위장 {
	public static void main(String[] args) {
		String[][] p = { { "crow_mask", "face" }, { "blue_sunglasses", "face" }, { "smoky_makeup", "face" } };

		int a = solution(p);
		System.out.println(a);
	}

	static int solution(String[][] clothes) {
		int answer = 1;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < clothes.length; i++) {
			if (map.containsKey(clothes[i][1]))
				map.put(clothes[i][1], map.get(clothes[i][1]).intValue() + 1);
			else {
				map.put(clothes[i][1], 1);
			}
		}

		Object key[] = map.keySet().toArray();
		for (Object a : key) {
			answer *= map.get((String) a) + 1;
		}

		answer -= 1;

		return answer;
	}
}