import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int dp[][], previousDPNumber;
    static String A, B;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static StringBuilder sb2 = new StringBuilder();

    public static void main(String[] args) throws IOException {
        init();
//        process();
    }

    private static void process() {



    }

    private static void init() throws IOException {
        System.out.println("    8888888888  888    88888\n" +
                "   88     88   88 88   88  88\n" +
                "    8888  88  88   88  88888\n" +
                "       88 88 888888888 88   88\n" +
                "88888888  88 88     88 88    888888\n" +
                "\n" +
                "88  88  88   888    88888    888888\n" +
                "88  88  88  88 88   88  88  88\n" +
                "88 8888 88 88   88  88888    8888\n" +
                " 888  888 888888888 88  88      88\n" +
                "  88  88  88     88 88   88888888");
    }

}