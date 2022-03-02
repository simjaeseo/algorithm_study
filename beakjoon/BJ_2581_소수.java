package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class BJ_2581_소수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		LinkedList<Integer> list = new LinkedList<>();
		
		for (int i = M; i <= N ; i++) {
			if(i == 1)	continue;
			
			boolean flag = true;
			for (int j = 2; j < i; j++) {
				if(i%j == 0)	{
					flag=false;
					break;
				}
			}
			if(flag)	list.add(i);
		}
		
		int sum = 0;
		
		if(!list.isEmpty()) {
			for (int i : list) {
				sum += i;
			}
			
			System.out.println(sum);
			System.out.println(list.get(0));
		}else {
			System.out.println(-1);
		}
		
		
	}

}
