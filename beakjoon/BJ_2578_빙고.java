package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2578_빙고 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] bingo = new int[5][5];
		
		StringTokenizer st;
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				bingo[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int bingoCnt = 0;
		int lastNum = 0;
		int numCnt = 0;
		int cnt = 0;
		boolean flag2 = false;
		
		
		for (int i = 0; i < 5; i++) {
			if(flag2) break;
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				cnt++;
				lastNum = Integer.parseInt(st.nextToken());
				
				// 빙고판에 해당 수 탐색 후 0으로 초기화하고 flag를 통해 탐색 종료
				boolean flag = false;
				for (int k = 0; k < 5; k++) {
					for (int k2 = 0; k2 < 5; k2++) {
						if(bingo[k][k2] == lastNum)	{
							bingo[k][k2] = 0;
							flag = true;
							break;
						}
					}
					if(flag)	{
						flag = false;
						break;
					}
				}
				// 11개 부터 빙고 라인 찾기 시작.
				if(i>=2) {
					// 빙고 개수 탐색 ( 빙고가 3개가 되면 마지막 수 저장 후 출력)
					// 가로
					for (int k = 0; k < 5; k++) {
						for (int k2 = 0; k2 < 5; k2++) {
							if(bingo[k][k2] == 0)	numCnt++;
						}
						if(numCnt == 5)		bingoCnt++;
						numCnt=0;
					}
					//세로
					for (int k = 0; k < 5; k++) {
						for (int k2 = 0; k2 < 5; k2++) {
							if(bingo[k2][k] == 0)	numCnt++;
						}
						if(numCnt == 5)		bingoCnt++;
						numCnt=0;
					}

					//우하향 대각선
					for (int a = 0; a < 5; a++) {
						if(bingo[a][a] == 0)	numCnt++;
					}
					if(numCnt == 5)	bingoCnt++;
					numCnt=0;

					//우상향 대각선
					for (int q = 0; q < 5; q++) {
						if(bingo[q][4-q] == 0)	numCnt++;
					}
					if(numCnt == 5)		bingoCnt++;
					numCnt=0;
					
					if(bingoCnt >= 3) {
						System.out.print(cnt);
						flag2=true;
						break;
					}
				}
			}

		}
		
		
	}
}
