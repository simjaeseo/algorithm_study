package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1063_킹 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 상, 우상, 우, 우하, 하, 좌하, 좌, 좌상
		int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
		int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };

		char[] kingPositionInfoTmp = st.nextToken().toCharArray();
		char[] rockPositionInfoTmp = st.nextToken().toCharArray();
		int N = Integer.parseInt(st.nextToken());

		rockPositionInfoTmp[0] -= 'A';
		kingPositionInfoTmp[0] -= 'A';
		rockPositionInfoTmp[1] -= '1';
		kingPositionInfoTmp[1] -= '1';

		int[] rockPositionInfo = new int[2];
		int[] kingPositionInfo = new int[2];

		for (int i = 0; i < 2; i++) {
			rockPositionInfo[i] = rockPositionInfoTmp[i];
			kingPositionInfo[i] = kingPositionInfoTmp[i];
		}

        // 문제에서 주어지는 그림과 같이 적용하기 위해 작성
		kingPositionInfo[1] = 7 - kingPositionInfo[1];
		rockPositionInfo[1] = 7 - rockPositionInfo[1];

		int rockRow = rockPositionInfo[1];
		int rockCol = rockPositionInfo[0];
		int kingRow = kingPositionInfo[1];
		int kingCol = kingPositionInfo[0];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			int idx = 0;

			// T, RT, R, RB, B, LB, L, LT
			if (cmd.equals("T")) {
				idx = 0;
			} else if (cmd.equals("RT")) {
				idx = 1;
			} else if (cmd.equals("R")) {
				idx = 2;
			} else if (cmd.equals("RB")) {
				idx = 3;
			} else if (cmd.equals("B")) {
				idx = 4;
			} else if (cmd.equals("LB")) {
				idx = 5;
			} else if (cmd.equals("L")) {
				idx = 6;
			} else if (cmd.equals("LT")) {
				idx = 7;
			}

			// 움직이는 정보 받은 후 웁직였을때의 킹 row, col 값
			int kRow = kingRow + dr[idx];
			int kCol = kingCol + dc[idx];
			int rRow = rockRow + dr[idx];
			int rCol = rockCol + dc[idx];

			// 이동할 수 있을때,
			if (kRow >= 0 && kCol >= 0 && kRow < 8 && kCol < 8) {
				// 킹이 움직일 곳에 돌이 없을때,
				if (!(kRow == rockRow && kCol == rockCol)) {
					kingPositionInfo[1] += dr[idx];
					kingPositionInfo[0] += dc[idx];

					kingRow = kingPositionInfo[1];
					kingCol = kingPositionInfo[0];
					// 킹이 움직일 곳에 돌이 있을때,
				} else {
					// 돌도 같이 움직일 수 있다면
					if (rRow >= 0 && rCol >= 0 && rRow < 8 && rCol < 8) {
                        // 킹과 돌의 위치를 바꾼다
				        kingPositionInfo[1] += dr[idx];
						kingPositionInfo[0] += dc[idx];
						rockPositionInfo[1] += dr[idx];
						rockPositionInfo[0] += dc[idx];

                        // 킹과 돌의 위치를 변수에 저장
						kingRow = kingPositionInfo[1];
						kingCol = kingPositionInfo[0];
						rockRow = rockPositionInfo[1];
						rockCol = rockPositionInfo[0];
					}
                   // 돌이 같이 못움직인다는건 킹도 못움직인다는 뜻이니 고려 x
				}
			}
		}
		int resultKingRow = 7 - kingRow + 1;
		int resultRockRow = 7 - rockRow + 1;
		System.out.print((char) (kingCol + 'A'));
		System.out.println(resultKingRow);
		System.out.print((char) (rockCol + 'A'));
		System.out.println(resultRockRow);
	}
}

