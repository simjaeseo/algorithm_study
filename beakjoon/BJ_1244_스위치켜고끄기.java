package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1244_스위치켜고끄기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] switchArr = new int[N+1];
		
		switchArr[0] = -1;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N+1; i++) {
			switchArr[i] = Integer.parseInt(st.nextToken());
		}
		
		int studentNum = Integer.parseInt(br.readLine());
		
		int[][] students = new int[studentNum][2];
		
		for (int i = 0; i < studentNum; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				students[i][j] = Integer.parseInt(st.nextToken());
			}
			
			//남학생일때
			if(students[i][0] == 1) {
				int num = students[i][1];
				int tmp = num;
				while(num <= N) {
					if(switchArr[num] == 0)	switchArr[num] = 1;
					else	switchArr[num] = 0;
					num += tmp;
					
				}
			}else {
				// 여학생일때
				int num = students[i][1];
				int numLeft = num-1;
				int numRight = num+1;
				int cnt = 0;
				
				while(true) {
					if(numLeft >= 1 && numRight < N+1) {
						if(switchArr[numLeft] == switchArr[numRight]) {
							cnt++;
							numLeft--;
							numRight++;
						}else {
							break;
						}
					}else {
						
						break;
					}
				}
				
				
				for (int j = num-cnt; j <= num+cnt; j++) {
					if(switchArr[j] == 0)	switchArr[j] = 1;
					else	switchArr[j] = 0;
				}
			}
		}
		
		for (int i = 1; i < N+1; i++) {
			System.out.print(switchArr[i] + " ");
			if(i%20 == 0)	System.out.println();
		}
		
	}

}
