package algo;

import java.util.LinkedList;
import java.util.List;
import java.util.Collections;

public class level1_K번째수 {
	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];

		for (int i = 0; i < commands.length; i++) {
			List<Integer> l = new LinkedList<>();
			for (int j = commands[i][0] - 1; j < commands[i][1]; j++) {
				l.add(array[j]);
			}
			Collections.sort(l);
			answer[i] = l.get(commands[i][2] - 1);
		}

		return answer;
	}
}
