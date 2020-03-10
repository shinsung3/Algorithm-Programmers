public class Main_전화번호목록 {
	public static void main(String[] args) {
		String[] p = { "123", "12", "1235", "567", "88" };
		boolean a = solution(p);
		System.out.println(a);
	}

	static boolean solution(String[] phone_book) {
		boolean answer = true;
		for (int i = 0; i < phone_book.length; i++) {
			for (int j = 0; j < phone_book.length; j++) {
				if (i != j) {
					if (phone_book[i].contains(phone_book[j])) {
						String str = "";
						String before = "";
						if (phone_book[i].length() > phone_book[j].length()) {
							str = phone_book[i];
							before = phone_book[j];
						} else {
							str = phone_book[j];
							before = phone_book[i];
						}
						String check = str.substring(0, before.length());
						if (check.equals(before)) {
							answer = false;
							break;
						}
					}
				}
				if (!answer)
					break;
			}
		}
		return answer;
	}
}