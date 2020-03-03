class Solution {
	public int solution(String str1, String str2) {
		int answer = 0;
		// 1. 가장 먼저 대소문자 구분 없이 만든다. => 모두 대문자로.
		str1 = str1.toUpperCase();
		str2 = str2.toUpperCase();

		// 2. 2개씩 쪼갬
		String[] first = new String[str1.length() - 1];
		String[] second = new String[str2.length() - 1];

		int idx = 0;
		for (int i = 0; i < str1.length() - 1; i++) {
			first[idx] = str1.substring(i, i + 2);
			idx++;
		}

		idx = 0;
		for (int i = 0; i < str2.length() - 1; i++) {
			second[idx] = str2.substring(i, i + 2);
			idx++;
		}

		// 3. 이상한 문자가 있다면 지워줌
		for (int i = 0; i < first.length; i++) {
			if (first[i].charAt(0) < 'A' || first[i].charAt(0) > 'Z' || first[i].charAt(1) < 'A'
					|| first[i].charAt(1) > 'Z') {
				first[i] = "-1";
			}
		}

		for (int i = 0; i < second.length; i++) {
			if (second[i].charAt(0) < 'A' || second[i].charAt(0) > 'Z' || second[i].charAt(1) < 'A'
					|| second[i].charAt(1) > 'Z') {
				second[i] = "-2";
			}
		}

		// 4. 둘이 비교하면서 찾기.
		int cnt = 0;
		for (int i = 0; i < first.length; i++) {
			for (int j = 0; j < second.length; j++) {
				if (first[i].equals(second[j])) {
					first[i] = "-1";
					second[j] = "-2";
					cnt++;
					break;
				}
			}
		}

		// 5. 전체를 돌면서 남은거 찾기.
		int ans = 0;
		for (int i = 0; i < first.length; i++) {
			if (!first[i].equals("-1")) {
				ans++;
			}
		}
		for (int i = 0; i < second.length; i++) {
			if (!second[i].equals("-2")) {
				ans++;
			}
		}

		// 6. 다중집합의 원소가 1개일 경우, 1이 된다.
		if ((ans + cnt) == 0) {
			answer = 65536;
		} else {
			answer = cnt * 65536 / (ans + cnt);
		}
		return answer;
	}
}