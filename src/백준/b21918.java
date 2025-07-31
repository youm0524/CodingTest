package 백준;
import java.util.Scanner;

public class b21918 {


        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[] lights = new int[N];
            for(int i = 0; i<N; i++){
                lights[i] = sc.nextInt();
            }

            for(int i = 0; i<M; i++){
                int a = sc.nextInt();
                int b = sc.nextInt()-1;
                int c = sc.nextInt()-1;
                if(a==1){
                    lights[b] = c+1;
                }
                else if(a==2){

                    for(int j = b; j<=c; j++){
                        if(lights[j]==0)lights[j] =1;
                        else lights[j]=0;
                    }
                }

                else if(a == 3){

                    for(int j = b; j<=c; j++){
                        lights[j] = 0;
                    }
                }
                else{

                    for(int j = b; j<=c; j++)lights[j] = 1;
                }
            }

            for(int i = 0; i<N; i++)System.out.print(lights[i]+" ");
        }

}
