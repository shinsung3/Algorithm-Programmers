import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main_길찾기게임 {
	public static void main(String[] args) {
		int[][] nodeinfo = { { 5, 3 }, { 11, 5 }, { 13, 3 }, { 3, 5 }, { 6, 1 }, { 1, 3 }, { 8, 6 }, { 7, 2 },
				{ 2, 2 } };
		int[][] ans = solution(nodeinfo);
		for (int[] a : ans)
			System.out.println(Arrays.toString(a));
	}

	static int[][] solution(int[][] nodeinfo) {
		int[][] answer = new int[2][nodeinfo.length];
		Node[] arr = new Node[nodeinfo.length];
		for (int i = 0; i < nodeinfo.length; i++) {
			arr[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1);
		}
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		Node root = arr[0];
		for (int i = 1; i < arr.length; i++) {
			searchAndInsert(root, arr[i]);
		}
		List<Integer> list = new LinkedList<Integer>();
		before(root, list);
		int idx=0;
		while(!list.isEmpty()) {
			answer[0][idx]= list.remove(0);
			idx++;
		}
		idx=0;
		after(root, list);
		while(!list.isEmpty()) {
			answer[1][idx]= list.remove(0);
			idx++;
		}
		return answer;
	}
	
	static void before(Node root, List<Integer> list) {
		list.add(root.value);
		if(root.left!=null) {
			before(root.left, list);
		}
		if(root.right!=null)
			before(root.right, list);
	}
	static void after(Node root, List<Integer> list) {
		if(root.left!=null) {
			after(root.left, list);
		}
		if(root.right!=null)
			after(root.right, list);
		list.add(root.value);
	}

	static void searchAndInsert(Node root, Node insertNode) {
		if (root.x > insertNode.x) {
			if (root.left != null) {
				searchAndInsert(root.left, insertNode);
			} else {
				root.left = insertNode;
			}
		} else {
			if (root.right != null) {
				searchAndInsert(root.right, insertNode);
			} else {
				root.right = insertNode;
			}
		}
	}

	static class Node implements Comparable<Node> {
		int x;
		int y;
		int value;
		Node left;
		Node right;

		public Node(int x, int y, int value) {
			super();
			this.x = x;
			this.y = y;
			this.value = value;
		}

		@Override
		public String toString() {
			return "value=" + value;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			if (o.y == this.y) {
				return o.x - this.x;
			} else {
				return o.y - this.y;
			}
		}
	}
}