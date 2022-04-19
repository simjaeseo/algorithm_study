package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_3190_뱀 {
	// 상좌하우
	static int[] dr = { -1, 0,1, 0 };
	static int[] dc = { 0, -1,0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		//처음 뱀 위치
		map[0][0] = 1;

		// 사과 개수
		int K = Integer.parseInt(br.readLine());

		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int appleR = Integer.parseInt(st.nextToken());
			int appleC = Integer.parseInt(st.nextToken());

			// 2는 사과
			map[appleR-1][appleC-1] = 2;
		}

		// 뱀 위치 정보 저장하는 연결리스트
		LinkedList<int[]> snake = new LinkedList<>();
		// 뱀 초기 위치 저장
		snake.add(new int[] { 0, 0 });
		//초기 방향 (3=오른쪽)
		int nowDirection = 3;
		int cnt = 0;
		
		//방향 정보 저장하는 연결리스트
		LinkedList<DirInfo> dirInfo = new LinkedList<>();

		// 뱀 방향 변환 횟수
		int L = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			char C = st.nextToken().charAt(0);
			
			//초가 오름차순으로 주어주니 뒤에 추가해줌
			dirInfo.addLast(new DirInfo(X, C));
		}
		while (true) {
			// 방향변환정보가 존재한다면
			if (!dirInfo.isEmpty()) {
				// 가장 가까운 X초가 cnt랑 같을때
				if (cnt == dirInfo.get(0).X) {
					// L이라면
					if (dirInfo.get(0).C == 'L') {
						nowDirection = (nowDirection + 1) % 4;
					// D라면
					} else {
						nowDirection = nowDirection - 1;
						if (nowDirection < 0)	nowDirection = 3;
					}
					// 방향변환정보 지워주기
					dirInfo.remove(0);
				}
			}
			
			int mr = snake.get(0)[0] + dr[nowDirection];
			int mc = snake.get(0)[1] + dc[nowDirection];

			// 벽에 부딪히거나 자기자신 부딪혔을때
			if (mr < 0 || mc < 0 || mr >= N || mc >= N  || map[mr][mc] == 1) {
				cnt++;
				break;
			}
			
			// 아무것도 없는공간으로 움직였을때
			if (map[mr][mc] == 0) {
				map[mr][mc] = 1;
				// 머리부분이니까 맨앞에 추가해주기
				snake.addFirst(new int[] { mr, mc });

				// 꼬리 지우기
				int lr = snake.get(snake.size() - 1)[0];
				int lc = snake.get(snake.size() - 1)[1];
				map[lr][lc] = 0;
				snake.remove(snake.size() - 1);
				cnt++;
			// 사과 있는 곳으로 움직였을때
			} else {
				map[mr][mc] = 1;
				snake.addFirst(new int[] { mr, mc });
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

	static class DirInfo {
		int X;
		char C;

		public DirInfo(int x, char c) {
			super();
			X = x;
			C = c;
		}
	}

}
