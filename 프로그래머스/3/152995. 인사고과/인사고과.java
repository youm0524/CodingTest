import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int[] wanho = scores[0];
        int wanhoSum = wanho[0] + wanho[1];

        // 1번 점수 내림차순
        // 1번 점수가 같으면 2번 점수 오름차순
        Arrays.sort(scores, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });

        int maxB = 0;
        int rank = 1;
        
        for(int i = 0; i<scores.length; i++){
            if(scores[i][1]<maxB){
                if(scores[i][0]==wanho[0] && scores[i][1]==wanho[1]){
                    return -1;
                }
                //탈락한 사람은 rank에 들어가면 안된다
                continue;
            }
            if(scores[i][0] + scores[i][1] >wanhoSum)rank++;
            maxB = Math.max(maxB, scores[i][1]);
        }

//         for (int[] score : scores) {

//             // 앞에 있는 사람 중
//             // 첫 번째 점수도 더 크고, 두 번째 점수도 더 큰 사람이 존재
//             if (score[1] < maxB) {

//                 // 완호가 탈락한 경우
//                 if (score[0] == wanho[0] && score[1] == wanho[1]) {
//                     return -1;
//                 }

//                 continue;
//             }

//             // 탈락하지 않은 사람 중
//             // 완호보다 합이 크면 순위가 하나 밀림
//             if (score[0] + score[1] > wanhoSum) {
//                 rank++;
//             }

//             maxB = Math.max(maxB, score[1]);
//         }

        return rank;
    }
}