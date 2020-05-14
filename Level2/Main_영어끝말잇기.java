import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
public class Main_영어끝말잇기 {
	public static void main(String[] args) {
		int n = 3;
		String[] words = {"T﻿ank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
		int[] a = solution(n, words);
		System.out.println(Arrays.toString(a));
	}
    public static int[] solution(int n, String[] words) {
		int[] answer = new int[2];
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		HashSet<String> set = new HashSet<String>();

		map.put(1, words[0]);
		set.add(words[0]);

		int play = 1;
		for (int i = 1; i < words.length; i++) {
			int put = (i + 1) % n;
			if (put == 1)
				play++;
			if (put == 0) {
				put = n;
			}
			int comp = put - 1;
			if (comp == 0) {
				comp = n;
			}

			int len = map.get(comp).length() - 1;
			char back = map.get(comp).charAt(len);
			char front = words[i].charAt(0);

			if (back == front) {
				if (!set.contains(words[i]))
					set.add(words[i]);
				else {
					answer[0] = put;
					answer[1] = play;
					break;
				}

				map.put(put, words[i]);
			} else {
				answer[0] = put;
				answer[1] = play;
				break;
			}

		}

		return answer;
	}
}