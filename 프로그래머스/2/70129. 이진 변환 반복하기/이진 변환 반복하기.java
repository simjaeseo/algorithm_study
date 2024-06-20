class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while(!s.equals("1")){
            int originSize = s.length();
            
            s = s.replaceAll("0", "");
            
            answer[1] += originSize - s.length();
            
            s = generateTwojinbeob(s.length());
            
            answer[0]++;
        }
        return answer;
    }
    
    static String generateTwojinbeob(int number){
        StringBuilder sb = new StringBuilder();
        
        while(true){
            
            if(number == 1){
                sb.append(1);
                sb.reverse();
                break;
            }
            
            sb.append(number % 2);
            number = number / 2;
        }
        return sb.toString();        
    }
}