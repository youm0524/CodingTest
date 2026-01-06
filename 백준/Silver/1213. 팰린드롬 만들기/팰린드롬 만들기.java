import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        String name = br.readLine();

        int[] arr = new int[26];
        int oddCount = 0;
        int middle = 0;

        for(int i=0; i<name.length(); i++){
            arr[name.charAt(i)-'A']++;
        }

        for(int i = 0; i<26; i++){
            if(arr[i] %2 != 0){
                oddCount++;
                middle = i;
            }
        }
        if(oddCount>=2) {System.out.println("I'm Sorry Hansoo"); return;}

        StringBuilder sb = new StringBuilder();

        //반절
        for(int i = 0; i<26; i++){
            for(int j = 0; j<arr[i]/2;j++){
                sb.append((char)(i+'A'));
            }
        }

        String front = sb.toString();

        if(oddCount == 1){
            front += (char) (middle + 'A');
        }

        String back = sb.reverse().toString();

        String answer = front+back;

        System.out.println(answer);

    }
}
