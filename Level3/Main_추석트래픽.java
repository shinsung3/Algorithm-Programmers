public class Main_추석트래픽 {
	public static void main(String[] args) throws Exception {
//		String[] lines = { "2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s",
//				"2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s", "2016-09-15 20:59:59.591 1.412s",
//				"2016-09-15 21:00:00.464 1.466s", "2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s",
//				"2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s" };
		String[] lines = { "2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s" };
		int a = solution(lines);
		System.out.println(a);
	}

	static int solution(String[] lines) {
		int answer = 0;
		start = new int[lines.length];
		end = new int[lines.length];
		getChangeMS(lines);
//		System.out.println(Arrays.toString(start));
//		System.out.println(Arrays.toString(end));

		for (int i = 0; i < lines.length; i++) {
			int checkStart = start[i];
			int checkEnd = start[i] + 1000;
			int cnt = 0;
			for (int j = 0; j < lines.length; j++) {
				if (start[j] >= checkStart && start[j] < checkEnd) {
					cnt++;
				} else if (start[j] <= checkStart && end[j] >= checkEnd) {
					cnt++;
				} else if (end[j] >= checkStart && end[j] < checkEnd) {
					cnt++;
				}
			}
			answer = answer < cnt ? cnt : answer;
		}
		for (int i = 0; i < lines.length; i++) {
			int checkStart = end[i];
			int checkEnd = end[i] + 1000;
			int cnt = 0;
			for (int j = 0; j < lines.length; j++) {
				if (start[j] >= checkStart && start[j] < checkEnd) {
					cnt++;
				} else if (start[j] < checkStart && end[j] >= checkEnd) {
					cnt++;
				} else if (end[j] >= checkStart && end[j] < checkEnd) {
					cnt++;
				}
			}
			answer = answer < cnt ? cnt : answer;
		}
		return answer;
	}

	static int[] start;
	static int[] end;

	// 예시 : 2016-09-15 20:59:57.421 0.351s
	static void getChangeMS(String[] lines) {
		for (int i = 0; i < lines.length; i++) {
			String dayNtimeNduring[] = lines[i].split(" ");
			String[] time = dayNtimeNduring[1].split(":");
			int ms = Integer.parseInt(time[0]) * 60 * 60 * 1000 + Integer.parseInt(time[1]) * 60 * 1000
					+ (int) (Double.parseDouble(time[2]) * 1000);
			end[i] = ms;
			int startMS = (int) (Double.parseDouble(dayNtimeNduring[2].substring(0, dayNtimeNduring[2].length() - 1))
					* 1000);
			start[i] = ms - startMS + 1;
		}
	}
}