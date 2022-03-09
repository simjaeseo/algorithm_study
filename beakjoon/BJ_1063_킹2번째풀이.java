package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1063_킹2번째풀이 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		char[] king = st.nextToken().toCharArray();
		char[] rock = st.nextToken().toCharArray();
		int N = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			String cmd = br.readLine();
			char[] next_king = king.clone();
			char[] next_rock = rock.clone();

			move(cmd, next_king);
			if (range(next_king))
				continue;
			if (Arrays.equals(next_king, next_rock)) {
				move(cmd, next_rock);
				if (range(next_rock))
					continue;
			}

			king = next_king;
			rock = next_rock;
		}
		System.out.println(king);
		System.out.println(rock);
	}

	private static boolean range(char[] next) {
		return (next[0] < 'A' || next[0] > 'H' || next[1] < '1' || next[1] > '8');
	}

	private static void move(String cmd, char[] next) {
		switch (cmd) {
		case "R":
			next[0]++;
			break;
		case "L":
			next[0]--;
			break;
		case "T":
			next[1]++;
			break;
		case "B":
			next[1]--;
			break;
		case "RT":
			next[0]++;
			next[1]++;
			break;
		case "RB":
			next[0]++;
			next[1]--;
			break;
		case "LT":
			next[0]--;
			next[1]++;
			break;
		case "LB":
			next[0]--;
			next[1]--;
			break;
		}
	}
}
