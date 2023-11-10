import java.io.*;
import java.util.*;


public class Main {
    static double sumScore, sumGrade, sum;
    static String[] input;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();

        System.out.println(sum/sumScore);

    }


    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double gradeToNumber = 0;

        for (int i = 0; i < 20; i++) {
            input = br.readLine().split(" ");

            if(!input[2].equals("P")){
                sumScore += Double.parseDouble(input[1]);

                gradeToNumber = changeGradeToNumber(input[2]);

                sumGrade += gradeToNumber;

                sum += Double.parseDouble(input[1]) * gradeToNumber;
            }
        }
    }

    private static double changeGradeToNumber(String s) {
        double gradeToNumber = 0;

        switch (s){
            case "A+":
                gradeToNumber = 4.5;
                break;
            case "A0":
                gradeToNumber = 4.0;
                break;
            case "B+":
                gradeToNumber = 3.5;
                break;
            case "B0":
                gradeToNumber = 3.0;
                break;
            case "C+":
                gradeToNumber = 2.5;
                break;
            case "C0":
                gradeToNumber = 2.0;
                break;
            case "D+":
                gradeToNumber = 1.5;
                break;
            case "D0":
                gradeToNumber = 1.0;
                break;
            case "F":
                gradeToNumber = 0;
                break;
        }
        return gradeToNumber;
    }

}