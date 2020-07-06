public class Main_키패드누르기 {

	public static void main(String[] args) {
		int[] pad = { 0 };
		String hand = "left";

		String a = solution(pad, hand);
		System.out.println(a);
	}

	static String solution(int[] numbers, String hand) {
		StringBuilder sb = new StringBuilder();
		int[][] pad = new int[4][3];
		int key = 1;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				pad[i][j] = key;
				key++;
			}
		}
		pad[3][0] = -1;
		pad[3][2] = -1;

		Hand leftHand = new Hand(3, 0);
		Hand rightHand = new Hand(3, 2);
		int left = 3;
		int right = 3;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
				sb.append("L");
				if (numbers[i] == 1) {
					left = 0;
				} else if (numbers[i] == 4) {
					left = 1;
				} else {
					left = 2;
				}
				leftHand = new Hand(left, 0);
			} else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
				sb.append("R");
				if (numbers[i] == 3) {
					right = 0;
				} else if (numbers[i] == 6) {
					right = 1;
				} else {
					right = 2;
				}
				rightHand = new Hand(right, 0);
			} else {
				int leftKey = 0;
				int rightKey = 0;
				if (numbers[i] == 2) {
					leftKey = Math.abs(left - 0) + Math.abs(leftHand.x - 1);
					rightKey = Math.abs(right - 0) + Math.abs(rightHand.x - 1);
				} else if (numbers[i] == 5) {
					leftKey = Math.abs(left - 1) + Math.abs(leftHand.x - 1);
					rightKey = Math.abs(right - 1) + Math.abs(rightHand.x - 1);
				} else if (numbers[i] == 8) {
					leftKey = Math.abs(left - 2) + Math.abs(leftHand.x - 1);
					rightKey = Math.abs(right - 2) + Math.abs(rightHand.x - 1);
				} else {
					leftKey = Math.abs(left - 3) + Math.abs(leftHand.x - 1);
					rightKey = Math.abs(right - 3) + Math.abs(rightHand.x - 1);
				}
				if (leftKey < rightKey) {
					sb.append("L");
					if (numbers[i] == 2) {
						left = 0;
					} else if (numbers[i] == 5) {
						left = 1;
					} else if (numbers[i] == 8) {
						left = 2;
					} else {
						left = 3;
					}
					leftHand = new Hand(left, 1);
				} else if (leftKey > rightKey) {
					sb.append("R");
					if (numbers[i] == 2) {
						right = 0;
					} else if (numbers[i] == 5) {
						right = 1;
					} else if (numbers[i] == 8) {
						right = 2;
					} else {
						right = 3;
					}
					rightHand = new Hand(right, 1);
				} else {
					if (hand.equals("right")) {
						sb.append("R");
						if (numbers[i] == 2) {
							right = 0;
						} else if (numbers[i] == 5) {
							right = 1;
						} else if (numbers[i] == 8) {
							right = 2;
						} else {
							right = 3;
						}
						rightHand = new Hand(right, 1);
					} else {
						sb.append("L");
						if (numbers[i] == 2) {
							left = 0;
						} else if (numbers[i] == 5) {
							left = 1;
						} else if (numbers[i] == 8) {
							left = 2;
						} else {
							left = 3;
						}
						leftHand = new Hand(left, 1);
					}
				}
			}

		}
		return sb.toString();
	}

	static class Hand {
		int y;
		int x;

		public Hand(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

		@Override
		public String toString() {
			return "Hand [y=" + y + ", x=" + x + "]";
		}
	}
}