import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    static int N;
    static LinkedList<char[]> l = new LinkedList<>();
    static Set<String> vocaSet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        init();

    }



    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        Student[] students = new Student[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            students[i] = new Student(Integer.parseInt(st.nextToken()), st.nextToken(), i);
        }

        Arrays.sort(students);

        StringBuilder sb = new StringBuilder();

        for(Student student : students){
            sb.append(student.age).append(' ').append(student.name).append('\n');
        }

        System.out.println(sb.substring(0,sb.length()-1));
    }

    static class Student implements Comparable<Student>{
        int age;
        String name;
        int enterNumber;

        public Student(int age, String name, int enterNumber){
            this.age = age;
            this.name = name;
            this.enterNumber = enterNumber;
        }

        @Override
        public int compareTo(Student o){
            if(this.age != o.age){
                return this.age - o.age;
            }else{
                return this.enterNumber - o.enterNumber;
            }
        }
    }

}