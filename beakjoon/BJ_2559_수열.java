package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2559_수열 {
	static int max = Integer.MIN_VALUE, K, N;
	static boolean[] isSelected;
	static int[] numbers, input;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		 N = Integer.parseInt(st.nextToken());
		 K = Integer.parseInt(st.nextToken());
		
		 st = new StringTokenizer(br.readLine());		
		 input = new int[N];
		 numbers = new int[N];
		isSelected = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
//		generateSubset(0);
		
		for (int i = 0; i < N-K; i++) {
			int sum = 0;
			for (int j = i; j < i+K; j++) {
				sum += input[j];
			}
			max = Math.max(max, sum);
		}
		System.out.println(max);
		
		
		
	}
	
//	public static void generateSubset(int cnt) {
//		if(cnt == N ) {
//			int idx =0;
//			int check = 0;
//			for (int i = 0; i < N; i++) {
//				if(isSelected[i]) {
//					numbers[idx++] = input[i];
//					check++;
//				}
//			}
//			if(check == K) {
//				int sum = 0;
//				for (int i = 0; i < K; i++) {
//					System.out.print(numbers[i] + " ");
////					sum += numbers[i];
//				}
//				System.out.println();
//				max = Math.max(max, sum);
//			}
//			
//			return;
//		}
//		
//		isSelected[cnt] = true;
//		generateSubset(cnt+1);
//		isSelected[cnt] = false;
//		generateSubset(cnt+1);
//	}

}
