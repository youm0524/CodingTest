package 정올;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class j4726 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //누적합 구하기
        int[] A = new int[n];
        A[0] = arr[0];

        for(int i = 1; i<n; i++){
            A[i] = A[i-1] + arr[i];
        }


        int answer = Integer.MIN_VALUE;
        for(int i = 1; i<n-1; i++){
            //통이 제일 오른쪽에 있는경우, 한개는 [0]에 있는게 유리함
            int cas1 = (A[n-1] - A[0] -arr[i]) + (A[n-1] - A[i]);

            //통이 제일 왼쪽에 있는 경우, 한개는 [N-1]에 있는게 유리함
            int cas2 = A[n-2] - arr[i] + A[i-1];

            //통이 중간에 있는 경우, 양 끝에 벌이 있고 통을 i
            int cas3 = A[n-2]-A[i-1] + A[i] - A[0];

            answer = Math.max(answer, Math.max(Math.max(cas1, cas2), cas3));


        }
        System.out.println(answer);

    }

}
