import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

interface printString {
	void showString(String str);
}

public class Main_오픈채팅방 {
	// 구현부
	public static void main(String[] args) {
		String[] str = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
				"Change uid4567 Ryan" };
		solution(str);
	}

	public static String[] solution(String[] record) {
		List<Node> list = new ArrayList<>();
		HashMap<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < record.length; i++) {
			String[] str = record[i].split(" ");
			if(str.length==3) {
				map.put(str[1], str[2]);
			}
			if(str[0].equals("Enter")) {
				list.add(new Node(str[1], "님이 들어왔습니다."));
			}else if(str[0].equals("Leave")) {
				list.add(new Node(str[1], "님이 떠났습니다."));
			}
		}
		String[] answer = new String[list.size()];
		for(int i=0; i<answer.length; i++) {
			StringBuilder sb = new StringBuilder();
			sb.append(map.get(list.get(i).key)).append(list.get(i).value);
			answer[i] = sb.toString();
		}
		return answer;
	}
	
	static class Node{
		String key;
		String value;
		@Override
		public String toString() {
			return "[" + key + " " + value + "]";
		}
		public Node(String key, String value) {
			super();
			this.key = key;
			this.value = value;
		}
	}
}