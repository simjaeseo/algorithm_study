package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_1038_감소하는수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		if (N <= 10) {
			System.out.println(N);
		} else {
			// N이 11 이상이면 이상이면
			String s = String.valueOf(N);
			char[] c = s.toCharArray();

			System.out.println(find(c, N));
		}

	}

	static int find(char[] c, int N) {
		int num = 11;
		int cnt = 10;
		char[] c2 = c;

		while (true) {
			boolean flag = true;
			for (int i = 0; i < c2.length - 1; i++) {
				if (c2[i] <= c2[i + 1]) {
					flag = false;
					break;
				}
			}
			if(flag) {
				cnt++;
			}
			
			if(cnt == N) {
				if(num > N) num = -1;
				break;
			}
			System.out.println(num);
			num++;
			c2 = plusNum(num);
		}
		return num;
	}
	
	static char[] plusNum(int num) {
		String s = String.valueOf(num);
		char[] c = s.toCharArray();
		return c;
	}
	
}
