class Solution {
    public int solution(int n) {
        int answer = 0;
        
        char[] nBinaryArray = Integer.toBinaryString(n).toCharArray();
        
        int count = 0;
        for(char c : nBinaryArray){
            if(c == '1') count++;
        }
        
        int m = n+1;
        char[] mBinaryArray = null;
        while(true){

            int mCount = 0;
            
            mBinaryArray = Integer.toBinaryString(m).toCharArray();
        
            for(char c : mBinaryArray){
                if(c == '1') mCount++;
            }
            
            if(count == mCount){
                answer = m;
                break;
            }
            
            m++;
        }
        
        return answer;
    }
}