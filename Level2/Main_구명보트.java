import java.util.Arrays;

public class Main_구명보트 {
	public static int solution(int[] people, int limit) {
		Arrays.sort(people);

		// 가장 몸무게가 작은 사람이랑 가장 많이 나가는 사람이랑 같이 탈 수 있나 비교
		// 같이 탈 수 없다면 점점 덜 무거운 사람들과 비교
		// 같이 탈 수 있다면 끝.
		int answer = 0;
		// 1. 현재 people 배열의 길이를 index로 둠
		int index = people.length - 1;
		// 2. people 배열 시작부터 하나씩 올라가면서
		// 3. 제일 몸무게 큰 사람이랑 작은 사람 비교 초과한다면
		// 따로 태워하니까 answer 하나 추가, 제일 몸무게 높은 사람도 한칸 늘리고,
		// 가장 몸무게 작은 사람도 한칸 늘림
		for (int i = 0; i <= index; i++, answer++)
			while (index > i && people[i] + people[index--] > limit)
				answer++;

		return answer;
	}

	public static void main(String[] args) {
		int[] c = { 70, 40, 80, 40, 20 };
		int l = 100;
		int str = solution(c, l);
		System.out.println(str);
	}
}