package algo;

import java.util.*;
public class level2_카카오프렌즈컬러링북 {

	    static int numberOfArea;
	    static int maxSizeOfOneArea;
	    static boolean[][] isVisited;
	        
	    static int dr[];
	    static int dc[];
	    
	    static int maxR;
	    static int maxC;
	    
	    public int[] solution(int m, int n, int[][] picture) {
	        isVisited = new boolean[m][n];
	        
	       numberOfArea = 0;
	    maxSizeOfOneArea = 0;
	        
	        maxR = m;
	        maxC = n;
	        
	        dr = new int[]{0,0,-1,1};
	        dc = new int[]{-1,1,0,0};

	        
			for (int i = 0; i < m ; i++) {
				for (int j = 0; j < n; j++) {
					if(!isVisited[i][j] && picture[i][j] != 0){
	                    bfs(i, j, picture[i][j], picture);
	                    numberOfArea++;
	                }
				}
			}
	        
	        
	        int[] answer = new int[2];
	        answer[0] = numberOfArea;
	        answer[1] = maxSizeOfOneArea;
	        return answer;
	    }


	public static void bfs(int row, int col, int num, int[][] picture){
	    Queue<int[]> q = new LinkedList<>();
	    q.add(new int[] {row, col});
	    isVisited[row][col] = true;
	    
	    int numArea = 0;
	    int OneArea = 1;
	    
	    
	    while(!q.isEmpty()){
	        int[] position = q.poll();
	        
	        for (int i = 0; i < 4; i++) {
				int mr = position[0] + dr[i];
				int mc = position[1] + dc[i];
	            
	            if(mr<0 || mc <0||mr>= maxR || mc>= maxC) continue;
	            if(num != picture[mr][mc] || isVisited[mr][mc]) continue;
	            
	            q.add(new int[] {mr, mc});
	            isVisited[mr][mc] = true;
	            OneArea++;
			}
	        
	    }
	   
	    
	    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, OneArea);
	    
	}
}
