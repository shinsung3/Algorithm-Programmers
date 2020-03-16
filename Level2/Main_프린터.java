import java.util.LinkedList;
import java.util.Queue;

public class Main_프린터 {
	public static void main(String[] args) {
		int[] w = { 1,1,9,1,1,1 };
		int h = 0;
		int a = solution(w, h);
		System.out.println(a);
	}

	static int solution(int[] priorities, int location) {
		int answer = 0;
		Queue<Node> q = new LinkedList<>();
		int max = 0;
		for (int i = 0; i < priorities.length; i++) {
			q.add(new Node(i,priorities[i]));
			max = Math.max(max, priorities[i]);
		}
		
		int idx=0;
		while(!q.isEmpty()) {
			Node n = q.poll();
			if(max==n.value) {
				answer++;
				if(n.num==location)
					break;
				idx=0;
			}else {
				q.add(n);
				idx++;
				if(idx==q.size()) {
					idx=0;
					max--;
				}
			}
		}
		return answer;
	}
	
	static class Node {
		int num;
		int value;
		public Node(int num, int value) {
			super();
			this.num = num;
			this.value = value;
		}
		@Override
		public String toString() {
			return "Node [num=" + num + ", value=" + value + "]";
		}
	}
}