package 백준;

import java.util.*;
import java.io.*;

public class b17413{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '<') {
                // 태그 시작 전까지 쌓인 단어 뒤집어서 출력
                while (!stack.isEmpty()) sb.append(stack.pop());

                // 태그는 그대로 복사 (i를 직접 이동)
                sb.append('<');      // 여는 꺾쇠 출력
                i++;                 // 다음 문자부터 검사
                while (i < s.length() && s.charAt(i) != '>') {
                    sb.append(s.charAt(i));
                    i++;
                }
                if (i < s.length()) sb.append('>'); // 닫는 꺾쇠 출력
                // 여기서 for문이 i++ 하면서 다음 문자로 이동 (현재 i는 '>' 위치)
            }
            else if (c == ' ') {
                // 단어 경계: 뒤집어서 출력 후 공백 출력
                while (!stack.isEmpty()) sb.append(stack.pop());
                sb.append(' ');
            }
            else {
                // 단어 구성 문자: 스택에 쌓기
                stack.push(c);
            }
        }

        // 마지막 단어 처리
        while (!stack.isEmpty()) sb.append(stack.pop());

        System.out.println(sb.toString());
    }
}
