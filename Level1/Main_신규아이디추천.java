public class Main_신규아이디추천 {
	public static void main(String[] args) {
		System.out.println(solution("123_.def"));
	}

	static String solution(String new_id) {
		String answer = "";
		// 1.
		new_id = new_id.toLowerCase();
//		System.out.println("1. "+new_id);

		// 2.
		int len = new_id.length();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			if (new_id.charAt(i) >= 'a' && new_id.charAt(i) <= 'z') {
				sb.append(new_id.charAt(i));
			} else if (new_id.charAt(i) == '-' || new_id.charAt(i) == '_' || new_id.charAt(i) == '.') {
				sb.append(new_id.charAt(i));
			} else if (new_id.charAt(i) >= '0' && new_id.charAt(i) <= '9') {
				sb.append(new_id.charAt(i));
			}
		}
		new_id = sb.toString();
//		System.out.println("2. " +new_id);

		// 3. ...bat..y.abcdefghijklm -> .
		sb = new StringBuilder();
		int idx = 0;
		if (new_id.length() >= 2) {
			while (true) {
				if (new_id.charAt(idx) == '.') {
					sb.append(new_id.charAt(idx));
					for (int j = idx + 1; j < new_id.length(); j++) {
						if (new_id.charAt(j) != '.') {
							idx = j;
							break;
						}else {
							idx=j;
						}
					}
				} else {
					sb.append(new_id.charAt(idx));
					idx++;
				}
				if (idx >= new_id.length()-1) {
					if(new_id.charAt(new_id.length()-1)!='.') {
						sb.append(new_id.charAt(idx));
					}
					break;
				}
			}
			new_id = sb.toString();
		}
		System.out.println("3. " + new_id);

		// 4.
		while (true) {
			boolean flag = false;
			// 4.
			if (new_id.length() != 0) {
				if (new_id.charAt(0) == '.') {
					flag = true;
					new_id = new_id.substring(1);
				}
			}
//			System.out.println("4. " + new_id);

			if (new_id.length() != 0) {
				if (new_id.charAt(new_id.length() - 1) == '.') {
					flag = true;
					new_id = new_id.substring(0, new_id.length() - 1);
				}
			}
			if (!flag)
				break;
//			System.out.println("4. " + new_id);
		}
		while (true) {
			boolean flag = false;
			// 4.
			if (new_id.length() != 0) {
				if (new_id.charAt(0) == '.') {
					flag = true;
					new_id = new_id.substring(1);
				}
			}

			if (new_id.length() != 0) {
				if (new_id.charAt(new_id.length() - 1) == '.') {
					flag = true;
					new_id = new_id.substring(0, new_id.length() - 1);
				}
			}
			if (!flag)
				break;
		}
//		System.out.println("4. " +new_id);
		// 5.
		if (new_id.length() == 0) {
			new_id = "a";
//			System.out.println("5. "+ new_id);
		}

		// 6.
		if (new_id.length() >= 16) {
			new_id = new_id.substring(0, 15);
			while (true) {
				boolean flag = false;
				if (new_id.charAt(new_id.length() - 1) == '.') {
					flag = true;
					new_id = new_id.substring(0, new_id.length() - 1);
				}
				if (!flag)
					break;
			}
//			System.out.println("6. "+ new_id);
		}

		// 7.

		sb = new StringBuilder();
		sb.append(new_id);
		while (true) {
			len = sb.toString().length();
			boolean flag = false;
			if (len <= 2) {
				flag = true;
				sb.append(sb.toString().charAt(len - 1));
			}
			if (!flag) {
				new_id = sb.toString();
				break;
			}
		}
//		System.out.println("7. "+new_id);
		answer = new_id;
		return answer;
	}
}
