import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {

                List<String> A = split(s1);
                List<String> B = split(s2);

                int len = Math.min(A.size(), B.size());

                for (int i = 0; i < len; i++) {
                    String a = A.get(i);
                    String b = B.get(i);

                    boolean isNumA = Character.isDigit(a.charAt(0));
                    boolean isNumB = Character.isDigit(b.charAt(0));

                    // 숫자 vs 숫자
                    if (isNumA && isNumB) {
                        int result = compareNumber(a, b);
                        if (result != 0) return result;
                    }
                    // 숫자 vs 문자
                    else if (isNumA) {
                        return -1;
                    }
                    else if (isNumB) {
                        return 1;
                    }
                    // 문자 vs 문자
                    else {
                        int result = compareString(a, b);
                        if (result != 0) return result;
                    }
                }

                return A.size() - B.size();
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s).append("\n");
        }

        System.out.print(sb);
    }

    // 🔹 문자열을 숫자/문자 토큰으로 분리
    static List<String> split(String s) {
        List<String> list = new ArrayList<>();
        int i = 0;

        while (i < s.length()) {
            int start = i;

            if (Character.isDigit(s.charAt(i))) {
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    i++;
                }
            } else {
                while (i < s.length() && !Character.isDigit(s.charAt(i))) {
                    i++;
                }
            }

            list.add(s.substring(start, i));
        }

        return list;
    }

    // 🔹 숫자 비교
    static int compareNumber(String a, String b) {

        String na = removeLeadingZero(a);
        String nb = removeLeadingZero(b);

        // 길이 비교
        if (na.length() != nb.length()) {
            return na.length() - nb.length();
        }

        // 길이 같으면 문자열 비교
        int cmp = na.compareTo(nb);
        if (cmp != 0) return cmp;

        // 숫자값 같으면 0 적은 게 먼저
        return a.length() - b.length();
    }

    // 🔹 앞의 0 제거
    static String removeLeadingZero(String s) {
        int i = 0;

        while (i < s.length() && s.charAt(i) == '0') {
            i++;
        }

        if (i == s.length()) return "0";

        return s.substring(i);
    }

    // 🔹 문자 비교
    static int compareString(String a, String b) {

        int len = Math.min(a.length(), b.length());

        for (int i = 0; i < len; i++) {

            char ca = a.charAt(i);
            char cb = b.charAt(i);

            char lowerA = Character.toLowerCase(ca);
            char lowerB = Character.toLowerCase(cb);

            if (lowerA != lowerB)
                return lowerA - lowerB;

            if (ca != cb)
                return ca - cb;  // 대문자 먼저
        }

        return a.length() - b.length();
    }
}
