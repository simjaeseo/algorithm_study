package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2789_블랙잭 {
	static int[] pickNum = new int[3];
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int[] numbers = new int[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		combi(0,0,N,M,numbers);
		
		System.out.println(max);
		
	}
	
	static void combi(int nextIdx ,int cnt, int N, int M, int[] numbers) {
		if(cnt == 3) {
			int sum = 0;
			for (int i = 0; i < 3; i++) {
				sum += pickNum[i];
			}
			if(sum<=M)	max = Math.max(sum, max);
			return;
		}
		
		for (int i = nextIdx; i < N; i++) {
			pickNum[cnt] = numbers[i];
			combi(i+1, cnt+1, N,M, numbers);
		}
		
		
	}

}
