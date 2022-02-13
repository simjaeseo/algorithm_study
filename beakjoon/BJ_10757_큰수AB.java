package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_10757_큰수AB {

	public static void main(String[] args) throws IOException {
		
		Stack<Integer> A = new Stack<>();
		Stack<Integer> B = new Stack<>();
		Stack<Integer> result = new Stack<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		char[] arrA = st.nextToken().toCharArray();
		char[] arrB = st.nextToken().toCharArray();
		
		for (int i = 0; i < arrA.length; i++) {
			A.push(arrA[i] - '0');
		}
		for (int i = 0; i < arrB.length; i++) {
			B.push(arrB[i] - '0');
		}
		
		int carry = 0;
		int numA = 0;
		int numB = 0;
		while (!A.isEmpty() || !B.isEmpty()) {
			
			if(A.isEmpty())	numA = 0;
			else	numA = A.pop();
			if(B.isEmpty())	numB = 0;
			else	numB = B.pop();
			
			if(numA+numB + carry >= 10)	{
				result.push(numA+numB + carry - 10);
				carry = 0;
				carry++;
			}else {
				result.push(numA+numB + carry);
				carry = 0;
			}
		}
		if(carry == 1)	result.push(carry);
		
		
		int size = result.size();
		
		for (int i = 0; i < size; i++) {
			System.out.print(result.pop());
		}
	}

}
