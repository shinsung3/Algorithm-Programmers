class Solution {
	public int solution(String name) {
		int answer = 0;
		int[] num = new int[name.length()];

		// 1. 가장 먼저 각 알파벳이 몇개씩 움직였는지 확인
		boolean isZero = false;
		for (int i = 0; i < name.length(); i++) {
			int up = (int) (name.charAt(i) - 'A');
			int down = (int) ('Z' - name.charAt(i)) + 1;
			if (up == 0) {
				isZero = true;
			}
			num[i] = (up > down) ? down : up;
		}

		for (int i = 0; i < name.length(); i++) {
			answer += num[i];
		}

		if (!isZero) {
			// 2. 오른쪽으로 끝까지 갈경우에는 그냥 length값을 더해주고
			answer += name.length() - 1;
		} else {
			// 3. 0이 있으면 오른쪾으로 갈지
			int idx = num.length - 1;
			int cnt = 0;
			int temp = 0;
			while (true) {
				if (idx == 0)
					break;

				if (num[idx] != 0) {
					if (temp != 0) {
						cnt += temp;
						temp = 0;
					}
					cnt++;
				} else {
					temp++;
				}
				idx--;
			}

			// 4. 왼쪽으로 갈지 정해봅시다.
			idx = 1;
			int cnt1 = 0;
			int temp1 = 0;
			while (true) {
				if (idx == num.length)
					break;

				if (num[idx] != 0) {
					if (temp1 != 0) {
						cnt1 += temp1;
						temp1 = 0;
					}
					cnt1++;
				} else {
					temp1++;
				}
				idx++;
			}

			cnt = Math.min(cnt1, cnt);

			// 5. 왼쪽으로 가다가 오른쪽으로 가볼까?
			idx = 1;
			int cnt2 = 0;
			int temp2 = 0;
			int key = 0;
			boolean isLeft = false;
			while (true) {
				if (!isLeft) {
					if (idx == num.length - 1)
						break;
				} else {
					if (idx == key)
						break;
				}

				if (num[idx] != 0) {
					if (temp2 != 0) {
						cnt2 += temp2;
						temp2 = 0;
					}
					cnt2++;
				} else {
					if (!isLeft) {
						isLeft = true;
						key = idx;
						// cnt2--;
					} else {
						temp2++;
					}
				}
				if (!isLeft)
					idx++;
				else {
					idx--;
					if (idx == 0) {
						idx = num.length - 1;
					}
				}
			}

			cnt = Math.min(cnt2, cnt);

			// 6. 왼쪽으로 가다가 오른쪽으로 가볼까?
			idx = num.length - 1;
			int cnt3 = 0;
			int temp3 = 0;
			isLeft = false;
			while (true) {
				if (!isLeft) {
					if (idx == 0)
						break;
				} else {
					if (idx == key)
						break;
				}

				if (num[idx] != 0) {
					if (temp3 != 0) {
						cnt3 += temp3;
						temp3 = 0;
					}
					cnt3++;
				} else {
					if (!isLeft) {
						isLeft = true;
						key = idx;
						// cnt3--;
					} else {
						temp3++;
					}
				}
				if (!isLeft)
					idx--;
				else {
					idx++;
					if (idx == num.length) {
						idx = 0;
					}
				}
			}

			cnt = Math.min(cnt3, cnt);
			answer += cnt;
		}

		return answer;
	}
}