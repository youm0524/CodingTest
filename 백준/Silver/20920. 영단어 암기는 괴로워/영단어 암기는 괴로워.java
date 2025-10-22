import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력: 단어의 개수 'n'과 최소 단어 길이 'm'을 읽음
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        // HashMap을 사용하여 길이가 'm' 이상인 단어들과 그 개수를 저장
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            String s = br.readLine();
            if(s.length()>=m){
                map.put(s, map.getOrDefault(s,0)+1);
            }
        }
        List<String> words = new ArrayList<>(map.keySet());
        
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int freq1 = map.get(o1);
                int freq2 = map.get(o2);
                
                // 1. 빈도 내림차순
                if (freq1 != freq2) {
                    return freq2 - freq1;
                }
                // 2. 길이 내림차순
                if (o1.length() != o2.length()) {
                    return o2.length() - o1.length();
                }
                // 3. 사전순 오름차순
                return o1.compareTo(o2);
            }
        });
        
        // 출력
        StringBuilder sb = new StringBuilder();
        for (String str : words) {
            sb.append(str).append("\n");
        }
        System.out.print(sb);
        
        
    }
}