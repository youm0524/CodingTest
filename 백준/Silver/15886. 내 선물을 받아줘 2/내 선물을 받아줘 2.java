import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 문자열 길이
        String move = br.readLine();

        int count = 0;

        for (int i = 0; i < N - 1; i++) {
            if (move.charAt(i) == 'E' && move.charAt(i + 1) == 'W') {
                count++;
            }
        }

        System.out.println(count);
    }
}