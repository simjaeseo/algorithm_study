package algo;

import java.util.Stack;

public class level1_크레인인형뽑기게임 {

	public int solution(int[][] board, int[] moves) {
		int answer = 0;
		Stack<Integer> s = new Stack<>();

		for (int i = 0; i < moves.length; i++) {
			int num = moves[i] - 1;

			// 뽑아야할 col값, board의 row값
			int pickNum = pick(num, board.length, board);

			if (pickNum != 0) {
				// 바구니의 맨 위 값을 먼저 꺼낸다
				// 바구니가 비어있다면 topNum = 0
				int topNum = 0;
				if (s.size() != 0) {
					topNum = s.peek();
				}

				if (pickNum == topNum) {
					answer += 2;
					s.pop();
				} else {
					s.add(pickNum);
				}

			}

		}

		return answer;
	}

	static public int pick(int num, int row, int[][] board) {

		for (int i = 0; i < row; i++) {
			if (board[i][num] != 0) {
				int pickNum = board[i][num];
				board[i][num] = 0;
				return pickNum;
			}
		}
		return 0;

	}

}
