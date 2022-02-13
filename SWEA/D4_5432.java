package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class D4_5432 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= T; i++) {
			String parathesis = br.readLine();
			
			
			char[] parathesisArr = parathesis.toCharArray();
			Stack<Character> stack = new Stack<>();
			int cnt = 0;
			int sum = 0;
			
			for (int j = 0; j < parathesisArr.length; j++) {
				switch (parathesisArr[j]) {
				case '(':
					stack.push(parathesisArr[j]);
					cnt++;
					break;
				case ')':
					cnt--;
					if(stack.peek() == '(') {
						sum += cnt;
					}else {
						sum++;
					}
					stack.push(parathesisArr[j]);
					break;
				}
				
			}
			System.out.println("#" + i + " " +sum);
			
			
		}
	}

}
