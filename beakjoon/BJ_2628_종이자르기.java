package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;


public class BJ_2628_종이자르기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int col = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> rowArr = new ArrayList<>();
		ArrayList<Integer> colArr = new ArrayList<>();
		
		int cut = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < cut; i++) {
			st = new StringTokenizer(br.readLine());
			if(Integer.parseInt(st.nextToken()) == 0) {
				rowArr.add(Integer.parseInt(st.nextToken()));
			}else {
				colArr.add(Integer.parseInt(st.nextToken()));
			}
		}
		rowArr.add(0);
		rowArr.add(row);
		colArr.add(0);
		colArr.add(col);
		
		Collections.sort(rowArr);
		Collections.sort(colArr);
		
		int maxRow = 0;
		int maxCol = 0;
		int tmp = 0;
		for (int i = 0; i < rowArr.size()-1; i++) {
			tmp = rowArr.get(i+1) - rowArr.get(i);
			maxRow = Math.max(tmp, maxRow);
		}
		
		for (int i = 0; i < colArr.size()-1; i++) {
			tmp = colArr.get(i+1) - colArr.get(i);
			maxCol = Math.max(tmp, maxCol);
		}
		System.out.println(maxRow*maxCol);
		
		
	}

}
