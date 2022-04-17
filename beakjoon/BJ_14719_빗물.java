package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_14719_빗물 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[][] map = new int[r][c];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < c; i++) {
			int height = Integer.parseInt(st.nextToken());
			for (int j = r-1; j >=r-height ; j--) {
				map[j][i] = 1;
			}
		}
		
		// 시작 벽 위치를 저장하기 위한 변수
		int startWall = 0;
		// 벽이 있었는지 없었는지 확인하기위한 변수
		boolean wall = false;
		// 벽사이에 빈공간이 있었는지 없었는지 확인하기위한 변수
		boolean empty = false;
		
		for (int i = r-1; i >=0; i--) {
			for (int j = 0; j < c; j++) {
				// 처음 벽을 만났을 경우
				if(!wall && map[i][j] == 1 ) {
					//현재 벽 위치 저장
					startWall = j;
					wall = true;
				//이전에 벽을 만났었고, 벽과 벽 사이에 빈공간이 있고, 현재 벽을 만났을 때
				}else if(wall && empty && map[i][j] == 1){
					// 이전의 벽 위치부터 현재 벽까지 빈공간을 빗물로 채움
					for (int j2 = startWall; j2 < j; j2++) {
						if(map[i][j2] == 0){
							map[i][j2] = 2;
						}
					}
					//현재 벽 위치 저장
					startWall = j;
					empty = false;
				}else if(map[i][j] == 0) {
					empty = true;
				}
			}
			wall = false;
			empty = false;
		}
		
		int cnt = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if(map[i][j] == 2) {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		
	}

}
