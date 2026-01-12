import java.util.Scanner;

public class Main {
    static char[] QUACK = {'q','u','a','c','k'};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sound = sc.next();

        int[] visit = new int[sound.length()];
        int answer = 0;
        if(sound.length()%5!=0 || sound.charAt(0) != 'q') {
            System.out.println(-1);
            return;
        }
        for(int i = 0; i<sound.length(); i++){
            if (visit[i]==1) continue;
            int count = 0;
            int idx = 0;
            for(int j = i; j<sound.length(); j++){
                if(visit[j]!=1 && QUACK[idx] == sound.charAt(j)){
                    visit[j]=1;
                    idx = (idx+1)%5;
                    count++;
                }
            }
            if(count%5==0){
                answer++;
            }
            else {
                System.out.println(-1);
                return;
            }

        }
        for (int i = 0; i < sound.length(); i++) {
            if (visit[i] == 0) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(answer);

    }
}
