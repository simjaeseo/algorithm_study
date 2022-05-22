package algo;

public class level1_로또의최고순위와최저순위 {
	public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
//         44, 1, 0, 0, 31 25
//         31, 10, 45, 1, 6, 19
            
//         [44, 1, 0, 0, 31, 25]	
//         [31, 10, 45, 1, 6, 19]	[3, 5]
            
//         [0, 0, 0, 0, 0, 0]
//         [38, 19, 20, 40, 15, 25]	[1, 6]
        
//         [45, 4, 35, 20, 3, 9]
//         [20, 9, 3, 45, 4, 35]	[1, 1]
            
//         당첨번호랑 뽑은번호랑 하나씩 비교하면서 같은거있으면 +1
//         cnt된 현재 상태가 최저순위
        int cnt = 0;
        int zero_cnt = 0;
        int min_grade = 0;
        int max_grade = 0;
        
        for(int num : win_nums){
            for(int minwoo_num : lottos){
                if(num == minwoo_num) cnt++;
                if(minwoo_num == 0) zero_cnt++;
            }
        }
        
        answer[0] = getGrade(cnt + zero_cnt/6);
        answer[1] = getGrade(cnt);
        
        
            
        return answer;
    }
    
    public static int getGrade(int num){
        int grade = 0;
        switch(num){
            case 0:
            case 1:
                grade = 6;
                break;
            case 2:
                grade = 5;
                break;
            case 3:
                grade = 4;
                break;
            case 4:
                grade = 3;
                break;
            case 5:
                grade = 2;
                break;
            case 6:
                grade = 1;
                break;
        }
        return grade;
    }
}
