package 자바알고리즘인터뷰.문자열;

import java.util.*;

public class leet_5 {
    // 팰린드롬 확장 함수
    public String expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    // 세 문자열 중 가장 긴 것 반환
    public String compare(String str1, String str2, String str3) {
        List<String> stringList = new ArrayList<>();
        stringList.add(str1);
        stringList.add(str2);
        stringList.add(str3);
        stringList.sort(Comparator.comparing(String::length));
        return stringList.get(stringList.size() - 1);
    }

    // 메인 알고리즘
    public String longestPalindrome(String s) {
        if (s.length() == 1) return s;
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            result = compare(expand(s, i, i), expand(s, i, i + 1), result);
        }
        return result;
    }

    // main 메서드(테스트 코드)
    public static void main(String[] args) {
        leet_5 solution = new leet_5();
        String s = "babad";
        String answer = solution.longestPalindrome(s);
        System.out.println("가장 긴 팰린드롬 부분 문자열: " + answer); // 예시 출력: "bab" 또는 "aba"
    }
}

