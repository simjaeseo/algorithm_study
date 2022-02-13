package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2635_수이어가기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		
		int max = 3;
		int result = 0;
		StringBuilder sb = new StringBuilder();
		sb.append(num + " ");
		
		for (int i = 1; i < num; i++) {
			
			int firstNum = num;
			int secondNum = i;
			int nextNum = firstNum - secondNum;
			int cnt = 1;
			
			while(nextNum >= 0) {
				nextNum = firstNum - secondNum;
				firstNum = secondNum;
				secondNum = nextNum;
				cnt++;
			}
			
			if(max < cnt) {
				max = cnt;
				result = i;
			}
		}
		
		int firstNum = num;
		int secondNum = result;
		int nextNum = firstNum - secondNum;
		
		sb.append(secondNum + " ");
		while(nextNum >= 0) {
			nextNum = firstNum - secondNum;
			firstNum = secondNum;
			secondNum = nextNum;
			
			sb.append(nextNum + " ");
		}
		
		String a = String.valueOf(nextNum);
		
		sb.setLength(sb.length() -2 -a.length());
		System.out.println(max);
		System.out.println(sb);
		
		
		
	}

}
