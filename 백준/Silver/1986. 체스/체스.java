import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		char[][] map = new char[row][col];

		// 나이트
		int[] dc = { 2, 2, 1, 1, -1, -1, -2, -2 };
		int[] dr = { 1, -1, 2, -2, 2, -2, 1, -1 };
		// 퀸
		int[] dc2 = { 1, -1, 0, 0, 1, 1, -1, -1 };
		int[] dr2 = { 0, 0, 1, -1, 1, -1, 1, -1 };

		st = new StringTokenizer(br.readLine());

		int qCnt = Integer.parseInt(st.nextToken());

		for (int i = 0; i < qCnt; i++) {
			int qRow = Integer.parseInt(st.nextToken()) - 1;
			int qCol = Integer.parseInt(st.nextToken()) - 1;

			map[qRow][qCol] = 'q';
		}

		st = new StringTokenizer(br.readLine());
		int kCnt = Integer.parseInt(st.nextToken());

		for (int i = 0; i < kCnt; i++) {
			int kRow = Integer.parseInt(st.nextToken()) - 1;
			int kCol = Integer.parseInt(st.nextToken()) - 1;

			map[kRow][kCol] = 'k';
		}

		st = new StringTokenizer(br.readLine());
		int pCnt = Integer.parseInt(st.nextToken());

		for (int i = 0; i < pCnt; i++) {
			int pRow = Integer.parseInt(st.nextToken()) - 1;
			int pCol = Integer.parseInt(st.nextToken()) - 1;

			map[pRow][pCol] = 'p';
		}

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (map[i][j] == 'k') {
					for (int j2 = 0; j2 < 8; j2++) {
						int moveRow = i + dr[j2];
						int moveCol = j + dc[j2];

						if (moveRow >= 0 && moveRow < row && moveCol >= 0 && moveCol < col) { // 배열 범위 내에 있으면서
							if (map[moveRow][moveCol] == '\u0000') {
								map[moveRow][moveCol] = 'x';
							}
						}
					}
				} else if (map[i][j] == 'q') {
					for (int j2 = 0; j2 < 8; j2++) {
						int moveRow = i + dr2[j2];
						int moveCol = j + dc2[j2];

						if (moveRow >= 0 && moveRow < row && moveCol >= 0 && moveCol < col) { // 배열 범위 내에 있으면서
							int tmpRow = moveRow;
							int tmpCol = moveCol;

							while (tmpRow >= 0 && tmpRow < row && tmpCol >= 0 && tmpCol < col) {
								if (map[tmpRow][tmpCol] != '\u0000' && map[tmpRow][tmpCol] != 'x')
									break;
								map[tmpRow][tmpCol] = 'x';
								tmpRow += dr2[j2];
								tmpCol += dc2[j2];
							}

//							if (map[moveRow][moveCol] == '\u0000') {
//								map[moveRow][moveCol] = 'x';
//							}
						}
					}
				}
			}
		}
		int cnt = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (map[i][j] == '\u0000')
					cnt++;
			}
		}
		System.out.println(cnt);
	}

}
