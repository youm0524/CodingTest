import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String tree : skill_trees) {
            Queue<String> queue = new LinkedList<>();

            for (int i = 0; i < tree.length(); i++) {
                String c = String.valueOf(tree.charAt(i));
                if (skill.contains(c)) {
                    queue.add(c);
                }
            }

            String out = "";
            boolean valid = true;

            while (!queue.isEmpty()) {
                String ss = queue.poll();
                out += ss;

                int idx = 0;
                for (int i = 0; i < skill.length(); i++) {
                    if (ss.equals(String.valueOf(skill.charAt(i)))) {
                        idx = i;
                        break;
                    }
                }

                if (idx != 0) {
                    String need = skill.substring(0, idx);
                    if (!out.contains(need)) {
                        valid = false;
                        break;
                    }
                }
            }

            if (valid) answer++;
        }

        return answer;
    }
}