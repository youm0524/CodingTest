package 자바알고리즘인터뷰.문자열;

import java.util.*;

public class leet_937 {
    public String[] reorderLogFiles(String[] logs) {
        List<String> letterList = new ArrayList<>();
        List<String> numList = new ArrayList<>();

        for (String s : logs) {
            if (Character.isDigit(s.split(" ")[1].charAt(0))) numList.add(s);
            else letterList.add(s);
        }

        letterList.sort((a, b) -> {
            String[] s1 = a.split(" ", 2);
            String[] s2 = b.split(" ", 2);
            int cmp = s1[1].compareTo(s2[1]);
            return cmp != 0 ? cmp : s1[0].compareTo(s2[0]);
        });

        letterList.addAll(numList);
        return letterList.toArray(new String[0]);
    }

    // 테스트용 main 메서드
    public static void main(String[] args) {
        leet_937 sol = new leet_937();
        String[] logs = {
                "dig1 8 1 5 1",
                "let1 art can",
                "dig2 3 6",
                "let2 own kit dig",
                "let3 art zero"
        };
        String[] result = sol.reorderLogFiles(logs);
        System.out.println(Arrays.toString(result));
    }
}
