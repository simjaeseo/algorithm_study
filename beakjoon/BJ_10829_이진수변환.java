package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_10829_이진수변환 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long N = Long.parseLong(br.readLine());
		Stack<Long> binary = new Stack<>();
		
		requr(N, binary);
		
	}
	
	static void requr(long N, Stack<Long> binary) {
		
		if(N == 1) {
			// 스택에 add
			binary.add(1l);
			
			while(!binary.isEmpty()) {
				System.out.print(binary.pop());
			}
			return;
		}
		
		binary.add(N%2);
		
		
		requr(N/2, binary);
		
		
		
	}

}
