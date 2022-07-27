package algoStudy;

public class level2_쿼드압축후개수세기 {

	    int[][] array;
	    int one, zero;
	    
	    public int[] solution(int[][] arr) {
	        int[] answer = new int[2];
	        
	        array = arr;
	        
	        slice(0,0,arr.length);
	        
	        answer[0] = zero;
	        answer[1] = one;
	        
	        return answer;
	    }
	    
	    public void slice(int r, int c, int arrSize){
	        int rEnd = r + arrSize;
	        int cEnd = c + arrSize;
	        int sum = 0;
	        
	        for(int i = r; i< rEnd; i++){
	            for(int j = c; j< cEnd ; j++){
	                sum += array[i][j];
	            }
	        }
	        
	        if(sum == arrSize*arrSize){
	            one++;
	        }else if(sum == 0){
	            zero++;
	        }else{
	            slice(r, c, arrSize/2);
	            slice(r, c+arrSize/2, arrSize/2);
	            slice(r+arrSize/2, c, arrSize/2);
	            slice(r+arrSize/2, c+arrSize/2, arrSize/2);
	        }
	        
	        
	        
	        
	    }
	    

}
