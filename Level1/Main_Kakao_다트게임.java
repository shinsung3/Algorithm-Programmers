import java.util.Arrays;

public class Main_Kakao_��Ʈ���� {
	public static void main(String[] args) {
		String dartResult = "1D2S#10S";

		int a = solution(dartResult);
		System.out.println(a);

	}

	public static int solution(String dartResult) {

		// 1.���ڰ� ��Ÿ���� �����ش�.
		// 2.���ڰ� ��Ÿ������ �ȿ� STD�� Ȯ�����ش�.
		// 3.* = ���ڸ��� ���� 2��
		// 4.# = ���� * (-1)���ֱ�
		int index = 0;
		int[] number = new int[3];
		for (int i = 0; i < dartResult.length(); i++) {
			if (dartResult.charAt(i) >= '0' && dartResult.charAt(i) <= '9') {
				StringBuilder sb = new StringBuilder();
				for(int j=i; j<dartResult.length(); j++) {
					if(dartResult.charAt(j)>='0' && dartResult.charAt(j)<='9')
						sb.append(dartResult.charAt(j));
					else
						break;
				}
				number[index] = Integer.parseInt(sb.toString());
				int idx = i+sb.toString().length();
				while (true) {
					if(idx>=dartResult.length()) {
						break;
					}
					char temp = dartResult.charAt(idx);
					if (temp >= '0' && temp <= '9')
						break;
					if (temp == 'D') {
						number[index] = (int) Math.pow(number[index], 2);
					} else if (temp == 'T') {
						number[index] = (int) Math.pow(number[index], 3);
					} else if (temp == '*') {
						if (index == 0)
							number[index] *= 2;
						else {
							number[index] *= 2;
							number[index - 1] *= 2;
						}
					} else if (temp == '#') {
						number[index] *= (-1);
					}
					idx++;
				} // while
				i = idx-1;
				index++;
			} // if
		}
		int answer = 0;
		for(int i=0; i<number.length; i++) {
			answer+=number[i];
		}
		return answer;
	}
}
