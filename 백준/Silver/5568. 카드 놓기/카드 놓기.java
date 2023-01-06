import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    static int k;
    static boolean[] isSelected;
    static String[] pickedNumber;
    static ArrayList<String> cards = new ArrayList<>();
    static HashSet<Integer> answer = new HashSet<>();


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String card = br.readLine();
            cards.add(card);
        }

        isSelected = new boolean[cards.size()];
        pickedNumber = new String[k];

        permutation(0);

        System.out.println(answer.size());

    }

    private static void permutation(int drawOfNumber) {
        if (drawOfNumber == k) {
            String combineCard = "";

            for(int i = 0; i<k ; i++){
                combineCard += pickedNumber[i];
            }

            answer.add(Integer.parseInt(combineCard));
            return;
        }

        for (int i = 0; i < cards.size(); i++) {

            if(isSelected[i]) continue;
            pickedNumber[drawOfNumber] = cards.get(i);
            isSelected[i] = true;
            permutation(drawOfNumber+1);
            isSelected[i] = false;
        }


    }
}