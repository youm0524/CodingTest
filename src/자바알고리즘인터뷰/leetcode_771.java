import java.util.HashSet;

public class leetcode_771 {
    public int numJewelsInStones(String jewels, String stones) {
        // Set을 사용해 보석 문자를 관리
        HashSet<Character> jewelSet = new HashSet<>();
        for (char c : jewels.toCharArray()) {
            jewelSet.add(c);
        }

        // stones 순회하며 보석 개수 세기
        int count = 0;
        for (char c : stones.toCharArray()) {
            if (jewelSet.contains(c)) {
                count++;
            }
        }
        return count;
    }

    // 테스트용 main 메서드(필요하면 사용)
    public static void main(String[] args) {
        leetcode_771 solution = new leetcode_771();
        String jewels = "aA";
        String stones = "aAAbbbb";
        System.out.println(solution.numJewelsInStones(jewels, stones)); // 결과는 3
    }
}
