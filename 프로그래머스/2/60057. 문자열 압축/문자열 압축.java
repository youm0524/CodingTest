import java.util.*;

class Solution {
    public int solution(String s) {
        int len = s.length();
        int start = 1;

        while (start <= s.length() / 2) {

            String prev = s.substring(0, start);
            int cnt = 1;
            String result = "";

            int i;

            for (i = start; i + start <= s.length(); i += start) {
                String next = s.substring(i, i + start);

                if (next.equals(prev)) {
                    cnt++;
                } else {
                    if (cnt == 1) {
                        result += prev;
                    } else {
                        result += cnt + prev;
                    }

                    prev = next;
                    cnt = 1;
                }
            }

            if (cnt == 1) {
                result += prev;
            } else {
                result += cnt + prev;
            }

            if (i < s.length()) {
                result += s.substring(i);
            }

            len = Math.min(len, result.length());

            start++;
        }

        return len;
    }
}