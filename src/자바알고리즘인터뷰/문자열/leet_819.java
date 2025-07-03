package 자바알고리즘인터뷰.문자열;

import java.util.*;

public class leet_819 {
    public static void main(String[] args) {
        leet_819 solution = new leet_819();
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        String result = solution.mostCommonWord(paragraph, banned);
        System.out.println("최빈 단어: " + result); // 출력: 최빈 단어: ball
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        // 데이터 전처리: 문장부호를 공백으로 바꾸고 소문자로 변환
        String[] replace = paragraph.replaceAll("\\W+", " ").toLowerCase().split(" ");

        // 금지어(banned) 집합 생성
        Set<String> ban = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> count = new HashMap<>();

        // 단어별 등장 횟수 카운트 (금지어 및 빈 문자열 제외)
        for (String S : replace) {
            if (!ban.contains(S) && !S.isEmpty()) {
                count.put(S, count.getOrDefault(S, 0) + 1);
            }
        }

        // 최빈 단어 반환
        return Collections.max(count.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}

