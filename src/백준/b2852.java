package 백준;

import javax.swing.*;
import java.util.Scanner;

public class b2852 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //변수 선언
        int N = sc.nextInt();
        int score_1= 0;
        int score_2 = 0;
        int s1_time =0;
        int s2_time = 0;
        int lastTime = 0;

        //반복문
        for(int i = 0; i<N; i++){
            int M = sc.nextInt();
            String[] time = sc.next().split(":");
            //초로 바꿔주기
            int times = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);

            //점수를 비교해서
            if(score_1>score_2) s1_time+=times-lastTime;
            else if(score_2>score_1) s2_time+=times-lastTime;

            //점수 올려주기
            if(M==1) score_1++;
            else score_2++;

            //기록 바꿔주기
            lastTime = times;
        }

        //마지막 시간도 더해줘야하니까
        if(score_1>score_2) s1_time+=48*60-lastTime;
        else if(score_2>score_1) s2_time+=48*60-lastTime;

        System.out.println(changeString(s1_time));
        System.out.println(changeString(s2_time));

    }

    static String changeString(int time){
        int min = time / 60;
        int sec = time % 60;
        return String.format("%02d:%02d", min, sec);
    }
}
