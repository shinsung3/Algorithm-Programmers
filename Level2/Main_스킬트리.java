class Solution {
	public int solution(String skill, String[] skill_trees) {
		int answer = 0;

		for (int i = 0; i < skill_trees.length; i++) {
			int idx = -1;
			boolean flag = false;
			for (int j = 0; j < skill_trees[i].length(); j++) {
				for (int k = 0; k < skill.length(); k++) {
					if (skill_trees[i].charAt(j) == skill.charAt(k)) {
						if (idx < k) {
							if (idx == -1 && k != 0) {
								flag = true;
								break;
							}
							if (Math.abs(idx - k) > 1) {
								flag = true;
								break;
							}
							idx = k;
						} else {
							flag = true;
							break;
						}
					}
				}
				if (flag) {
					break;
				}
			}
			if (!flag) {
				answer++;
			}
		}
		return answer;
	}
}