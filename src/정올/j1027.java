package 정올;


import java.io.*;
import java.util.*;

public class j1027 {
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        n = Integer.parseInt(br.readLine());

        // 여기부터 풀이 작성
        System.out.println(dfs(""));

    }
    public static String dfs(String s){
        if(s.length()==n){
            //System.out.println(s);
            return s;
        }
        for(int i = 1; i<=3; i++){
            String next = s + i;

            if(check(next)){
                String result = dfs(next);
                if(result!=null){
                    return result;
                }
            }

        }
        return null;
    }
    public static boolean check(String next) {
        int len = next.length();

        for (int i = 1; i <= len / 2; i++) {

            String a = next.substring(len - 2 * i, len - i);
            String b = next.substring(len - i, len);

            if (a.equals(b)) {
                return false;
            }
        }

        return true;
    }
}