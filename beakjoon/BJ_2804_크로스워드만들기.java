package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2804_크로스워드만들기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		char[] voca1 = st.nextToken().toCharArray();
		char[] voca2 = st.nextToken().toCharArray();
		
		int row =0;
		int col =0;
		boolean flag = false;
		
		for (int i = 0; i < voca1.length; i++) {
			for (int j = 0; j < voca2.length; j++) {
				if(voca1[i] == voca2[j]) {
					row = j;
					col = i;
					flag = true;
					break;
				}
			}
			if(flag)	break;
		}
		char[][] board = new char[voca2.length][voca1.length];
		for (int i = 0; i < voca2.length; i++) {
			for (int j = 0; j < voca1.length; j++) {
				board[i][j] ='.';
			}
		}
		
		board[row] = voca1;
		
		for (int i = 0; i < voca2.length; i++) {
			board[i][col] = voca2[i];
		}
		
		
		for (int i = 0; i < voca2.length; i++) {
			for (int j = 0; j < voca1.length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		
	}

}
