class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];

        for (int i = 0; i < 5; i++) {

            int flag = 0;

            String[][] place = new String[5][5];

            // 문자열 -> 2차원 배열 변환
            for (int j = 0; j < 5; j++) {
                for (int m = 0; m < 5; m++) {
                    place[j][m] = String.valueOf(places[i][j].charAt(m));
                }
            }

            for (int j = 0; j < 5; j++) {
                for (int m = 0; m < 5; m++) {

                    if (place[j][m].equals("P")) {

                        // 맨해튼 거리 1 아래
                        if (j < 4 && place[j + 1][m].equals("P")) {
                            flag = 1;
                        }

                        // 맨해튼 거리 1 오른쪽
                        if (m < 4 && place[j][m + 1].equals("P")) {
                            flag = 1;
                        }

                        // 거리 2 아래
                        if (j < 3 && place[j + 2][m].equals("P")) {
                            if (!place[j + 1][m].equals("X")) {
                                flag = 1;
                            }
                        }

                        // 거리 2 오른쪽
                        if (m < 3 && place[j][m + 2].equals("P")) {
                            if (!place[j][m + 1].equals("X")) {
                                flag = 1;
                            }
                        }

                        // 오른쪽 아래 대각선
                        if (j < 4 && m < 4 && place[j + 1][m + 1].equals("P")) {

                            if (!place[j][m + 1].equals("X")
                                    || !place[j + 1][m].equals("X")) {
                                flag = 1;
                            }
                        }

                        // 왼쪽 아래 대각선
                        if (j < 4 && m > 0 && place[j + 1][m - 1].equals("P")) {

                            if (!place[j][m - 1].equals("X")
                                    || !place[j + 1][m].equals("X")) {
                                flag = 1;
                            }
                        }
                    }
                }
            }

            if (flag == 1)
                answer[i] = 0;
            else
                answer[i] = 1;
        }

        return answer;
    }
}