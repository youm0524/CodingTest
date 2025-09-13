package 백준.Silver;

import java.util.Scanner;

public class b1138 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] people = new int[N];
        boolean[] check = new boolean[N];

        for(int i=1;i<=N;i++){
            int num = sc.nextInt();
            int count = 0;
            for(int j =0; j<N; j++){
                if(check[j] == false){
                    if(count == num){
                        people[j] = i;
                        check[j] = true;
                    }count++;
                }
            }
        }

        for(int i=0; i< people.length; i++){
            System.out.print(people[i]+ " ");
        }
    }
}
